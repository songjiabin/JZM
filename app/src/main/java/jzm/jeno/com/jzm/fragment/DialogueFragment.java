package jzm.jeno.com.jzm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jzm.jeno.com.jzm.ImageUtil.ImageLoader;
import jzm.jeno.com.jzm.JzmApplication;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.activity.ShowDialogueActivity;
import jzm.jeno.com.jzm.adapter.DialogueAdapter;
import jzm.jeno.com.jzm.base.BaseFragment;
import jzm.jeno.com.jzm.bean.JzmDialogueBean;
import jzm.jeno.com.jzm.mvp.dialogue.DialogueContract;
import jzm.jeno.com.jzm.mvp.dialogue.DialoguePresenter;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/20
 * desc   : 截图
 * version: 1.0.0
 */

public class DialogueFragment extends BaseFragment<DialogueContract.Presenter, DialogueContract.View> implements DialogueContract.View {


    @BindView(R.id.refresh_dialogue)
    protected SwipeRefreshLayout refresh_dialogue;

    @BindView(R.id.cy_dialogue)
    protected RecyclerView cy_dialogue;


    private DialogueAdapter dialogueAdapter;


    public static DialogueFragment newInstance(String category) {
        DialogueFragment dialogueFragment = new DialogueFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Contracts.KEY_PARAMS, category);
        dialogueFragment.setArguments(bundle);
        return dialogueFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dialogue;
    }

    @Override
    public DialogueContract.Presenter createPresenter() {
        return new DialoguePresenter();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        //进行初始化数据
        mPresenter.initData();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        //初始化  adapte  、 刷新控件参数等
        refresh_dialogue.setColorSchemeColors(
                JzmApplication.getContext().getResources().getColor(R.color.red_bg)
        );
        refresh_dialogue.setRefreshing(true);
        dialogueAdapter = new DialogueAdapter(new ArrayList<JzmDialogueBean.DialogueItemBean>());
        dialogueAdapter.setHeaderAndEmpty(true);
        dialogueAdapter.setEnableLoadMore(false);

        cy_dialogue.setAdapter(dialogueAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        cy_dialogue.setLayoutManager(layoutManager);

    }

    @Override
    protected void initViewListener() {

        refresh_dialogue.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.pullToRefresh(false);
            }
        });
        dialogueAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.pullToRefresh(true);
            }
        });
        dialogueAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                JzmDialogueBean.DialogueItemBean item = (JzmDialogueBean.DialogueItemBean) adapter.getItem(position);
                String url = item.getImg();
                ImageLoader.getBitmapByUrl(getContext(), url);
                showToast("保存图片到相册成功");
                return true;
            }
        });

        dialogueAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                JzmDialogueBean.DialogueItemBean item = (JzmDialogueBean.DialogueItemBean) adapter.getData().get(position);
                String img = item.getImg();
                Intent intent = new Intent(getActivity(), ShowDialogueActivity.class);
                intent.putExtra(Contracts.KEY_PARAMS, img);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        mPresenter.process();
    }

    @Override
    public void loadData(List<JzmDialogueBean.DialogueItemBean> jzmDialogueBean) {
        if (!refresh_dialogue.isRefreshing()) {
            dialogueAdapter.addData(jzmDialogueBean);
        }
        if (refresh_dialogue.isRefreshing()) {
            dialogueAdapter.setNewData(jzmDialogueBean);

            // 不显示动画需要设置在setNewData之后，否则无效
            dialogueAdapter.setNotDoAnimationCount(5);
            refresh_dialogue.setRefreshing(false);
        }

        // 由于添加了headerview,所以从下标1开始刷新
        dialogueAdapter.notifyDataSetChanged();
        dialogueAdapter.loadMoreComplete();
    }

    @Override
    public void showRequestError() {
        refresh_dialogue.setRefreshing(false);
    }

    @Override
    public void showLoadMoreRequestError() {
        dialogueAdapter.loadMoreFail();
    }
}
