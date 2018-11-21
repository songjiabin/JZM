package jzm.jeno.com.jzm.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jzm.jeno.com.jzm.JzmApplication;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.adapter.MenuItemAdapter;
import jzm.jeno.com.jzm.base.BaseFragment;
import jzm.jeno.com.jzm.bean.JzmMenuItemBean;
import jzm.jeno.com.jzm.mvp.menuitem.MenuItemContract;
import jzm.jeno.com.jzm.mvp.menuitem.MenuItemPresenter;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class MenuItemFragment extends BaseFragment<MenuItemContract.Presenter, MenuItemContract.View> implements MenuItemContract.View {


    @BindView(R.id.refresh_menu)
    protected SwipeRefreshLayout refresh_menu;

    @BindView(R.id.cy_menu)
    protected RecyclerView cy_menu;

    private MenuItemAdapter menuItemAdapter;


    public static MenuItemFragment newInstance(String category) {
        MenuItemFragment menuItemFragment = new MenuItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Contracts.KEY_PARAMS, category);
        menuItemFragment.setArguments(bundle);
        return menuItemFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_menu_item;
    }

    @Override
    public MenuItemContract.Presenter createPresenter() {
        return new MenuItemPresenter();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPresenter.initData(this.getArguments());
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        refresh_menu.setColorSchemeColors(
                JzmApplication.getContext().getResources().getColor(R.color.red_bg)
        );
        refresh_menu.setRefreshing(true);

        menuItemAdapter = new MenuItemAdapter(new ArrayList<JzmMenuItemBean>());
        menuItemAdapter.setHeaderAndEmpty(true);
        menuItemAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        menuItemAdapter.setEnableLoadMore(false);

        cy_menu.setAdapter(menuItemAdapter);
        cy_menu.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    protected void initViewListener() {
        menuItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });


        refresh_menu.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.pullToRefresh(false);
            }
        });
        menuItemAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.pullToRefresh(true);
            }
        });
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        mPresenter.process();
    }

    @Override
    public void updateData(List<JzmMenuItemBean> jzmMenuItemBeanList) {
        if (!refresh_menu.isRefreshing()) {
            menuItemAdapter.addData(jzmMenuItemBeanList);
        }
        if (refresh_menu.isRefreshing()) {
            menuItemAdapter.setNewData(jzmMenuItemBeanList);
            // 不显示动画需要设置在setNewData之后，否则无效
            menuItemAdapter.setNotDoAnimationCount(5);
            refresh_menu.setRefreshing(false);
        }

        menuItemAdapter.notifyDataSetChanged();
        menuItemAdapter.loadMoreComplete();
    }

    @Override
    public void showLoadMoreRequestError() {
        menuItemAdapter.loadMoreFail();
    }

    @Override
    public void showRequestError() {
        refresh_menu.setRefreshing(false);
    }


    @Override
    public void showToast(String message) {
        super.showToast(message);

        if (message.equals(getString(R.string.load_end))) {
            menuItemAdapter.loadMoreEnd();
        }
    }


}
