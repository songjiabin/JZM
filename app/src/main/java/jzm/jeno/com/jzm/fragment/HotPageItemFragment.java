package jzm.jeno.com.jzm.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jzm.jeno.com.jzm.MyApplication;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.adapter.HomePageItemAdapter;
import jzm.jeno.com.jzm.base.BaseFragment;
import jzm.jeno.com.jzm.bean.JzmNewBean;
import jzm.jeno.com.jzm.mvp.homepageitem.HomePageItemContract;
import jzm.jeno.com.jzm.mvp.homepageitem.HomePageItemPresenter;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/16
 * desc   :
 * version: 1.0.0
 */

public class HotPageItemFragment extends BaseFragment<HomePageItemContract.Presenter, HomePageItemContract.View> implements HomePageItemContract.View {


    @BindView(R.id.hotpage_refresh)
    protected SwipeRefreshLayout hotpage_refresh;

    @BindView(R.id.hotpage_lines)
    protected RecyclerView hotpage_lines;


    @BindView(R.id.include_empty_layout)
    protected View include_empty_layout;


    private HomePageItemAdapter homePageItemAdapter;
    private View mHeaderTag;
    private View mHeaderImg;


    public static HotPageItemFragment newInstance(String category) {
        HotPageItemFragment hotPageItemFragment = new HotPageItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Contracts.KEY_PARAMS, category);
        hotPageItemFragment.setArguments(bundle);
        return hotPageItemFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hotpage_item;
    }

    @Override
    public HomePageItemContract.Presenter createPresenter() {
        return new HomePageItemPresenter(getActivity());
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPresenter.initData(getArguments());
    }

    @Override
    protected void process(Bundle savedInstanceState) {

    }

    @Override
    protected void initViewListener() {
        hotpage_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.pullToRefresh(false);
            }
        });

        homePageItemAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.i("loading", "loading");
                mPresenter.pullToRefresh(true);
            }
        });
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        hotpage_refresh.setColorSchemeColors(
                MyApplication.getContext().getResources().getColor(R.color.red_bg)
        );
        homePageItemAdapter = new HomePageItemAdapter(new ArrayList<JzmNewBean.JzmNewItemBean>());
        homePageItemAdapter.setHeaderAndEmpty(true);
        homePageItemAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        homePageItemAdapter.setEnableLoadMore(false);
        hotpage_lines.setAdapter(homePageItemAdapter);
        hotpage_lines.setLayoutManager(new LinearLayoutManager(getContext()));

        homePageItemAdapter.removeAllHeaderView();
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.hotpage_header, null);
        homePageItemAdapter.addHeaderView(headerView);

        mHeaderTag = headerView.findViewById(R.id.header_tag);
        mHeaderImg = headerView.findViewById(R.id.header_img);

        hotpage_refresh.setRefreshing(true);
    }


    @Override
    public void showMessage(String message) {
        if (!isAdded()) {
            //如果没有加载完成的话
            showToast(message);
        }
    }

    @Override
    public void updateData(List<JzmNewBean.JzmNewItemBean> jzmNewItemBeans) {
        if (!hotpage_refresh.isRefreshing()) {
            homePageItemAdapter.addData(jzmNewItemBeans);
        }
        if (hotpage_refresh.isRefreshing()) {
            homePageItemAdapter.setNewData(jzmNewItemBeans);

            // 不显示动画需要设置在setNewData之后，否则无效
            homePageItemAdapter.setNotDoAnimationCount(5);
            hotpage_refresh.setRefreshing(false);
        }

        // 由于添加了headerview,所以从下标1开始刷新
        homePageItemAdapter.notifyItemChanged(1, jzmNewItemBeans.size());
        homePageItemAdapter.loadMoreComplete();
    }
}
