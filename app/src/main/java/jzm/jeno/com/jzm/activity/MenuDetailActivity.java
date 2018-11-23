package jzm.jeno.com.jzm.activity;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jzm.jeno.com.jzm.ImageUtil.ImageLoader;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.adapter.MenuDetailAdapter;
import jzm.jeno.com.jzm.adapter.MenuDetailWorksAdapter;
import jzm.jeno.com.jzm.base.BaseActivity;
import jzm.jeno.com.jzm.bean.JzmMenuDetailBean;
import jzm.jeno.com.jzm.mvp.menudetail.MenuDetailContract;
import jzm.jeno.com.jzm.mvp.menudetail.MenuDetailPresenter;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   : 分类详情
 * version: 1.0.0
 */

public class MenuDetailActivity extends BaseActivity<MenuDetailContract.Presenter, MenuDetailContract.View> implements MenuDetailContract.View {

    @BindView(R.id.article_background_layout)
    public RelativeLayout mBackgroundLayout;
    @BindView(R.id.search_result_coord)
    public CollapsingToolbarLayout mCollLayout;
    @BindView(R.id.toolbar)
    public Toolbar mToolbar;
    @BindView(R.id.article_img)
    public ImageView mImgBg;
    @BindView(R.id.article_rcy)
    public RecyclerView mRecyclerView;
    @BindView(R.id.article_processbar)
    public ContentLoadingProgressBar mProgressBar;


    private String mLink;
    private String mTitle;

    private MenuDetailAdapter mAdapter;
    private MenuDetailWorksAdapter menuDetailWorksAdapter;

    @Override
    protected int getLayouId() {
        return R.layout.activity_menu_detail;
    }

    @Override
    protected void initData() {
        mLink = getIntent().getExtras().getString(Contracts.KEY_PARAMS_1);
        if (mLink.contains(Contracts.MENU_DETAILS_URL)) {
            mLink = mLink.replaceAll(Contracts.MENU_DETAILS_URL, "");
        }
        mTitle = getIntent().getExtras().getString(Contracts.KEY_PARAMS_2);
        mPresenter.initData();
    }

    @Override
    protected void initView() {


        mCollLayout.setTitle(mTitle);
        mToolbar.setNavigationIcon(R.mipmap.ic_back_white);
        mCollLayout.setExpandedTitleColor(this.getResources().getColor(android.R.color.white));////设置展开后标题的颜色
        mCollLayout.setExpandedTitleTypeface(Typeface.create("bold", Typeface.BOLD));
        mCollLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));//设置收缩后标题的颜色
//        mCollLayout.setCollapsedTitleGravity(Gravity.CENTER);//设置收缩后标题的位置
        mCollLayout.setExpandedTitleGravity(Gravity.CENTER);////设置展开后标题的位置

        setSupportActionBar(mToolbar);

        mProgressBar.getIndeterminateDrawable()
                .setColorFilter(ContextCompat.getColor(this, R.color.orange), PorterDuff.Mode.MULTIPLY);
        mProgressBar.show();


        mAdapter = new MenuDetailAdapter(new ArrayList<JzmMenuDetailBean.JzmMenuDetailItemBean>());
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mAdapter.setNotDoAnimationCount(5);
        mAdapter.setHeaderAndEmpty(true);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        menuDetailWorksAdapter = new MenuDetailWorksAdapter(new ArrayList<String>());

    }

    @Override
    protected void process() {
        mPresenter.process(mLink);
    }

    @Override
    protected void initViewListener() {
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.loadMore();
            }
        });

    }

    @Override
    public MenuDetailContract.Presenter createPresenter() {
        return new MenuDetailPresenter();
    }


    @Override
    public void updateData(List<JzmMenuDetailBean.JzmMenuDetailItemBean> jzmMenuDetailItemBeans) {
        mProgressBar.hide();
        mAdapter.addData(jzmMenuDetailItemBeans);
        mAdapter.notifyDataSetChanged();
        mAdapter.loadMoreComplete();
    }

    @Override
    public void showLoadMoreRequestError() {
        mAdapter.loadMoreFail();
    }

    @Override
    public void showRequestError() {
        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void showMessage(String msg) {
        if (msg.equals(getString(R.string.load_end))) {
            mAdapter.loadMoreEnd();
        }
        showToast(msg);
    }

    @Override
    public void updateHead(Bundle bundle) {
        String pageUrl = bundle.getString(Contracts.ARTICLE_PAGE_URL);
        String intro = bundle.getString(Contracts.ARTICLE_PAGE_INTRO);

        ArrayList<String> works = bundle.getStringArrayList(Contracts.ARTICLE_PAGE_RELATED);

        ImageLoader.loadTransformByUrl(this, mImgBg, "http:" + pageUrl);

        mAdapter.removeAllHeaderView();
        View view = LayoutInflater.from(this).inflate(R.layout.layout_menu_detail_header, null);


        mAdapter.addHeaderView(view);

        TextView tvIntro = view.findViewById(R.id.article_intro_content);
        tvIntro.setText(intro);

        TextView tvRelateEmpty = view.findViewById(R.id.article_related_empty);
        if (works == null || works.size() == 0) {
            tvRelateEmpty.setVisibility(View.VISIBLE);
        }

        RecyclerView rcyRelated = view.findViewById(R.id.article_related_content);
        rcyRelated.setAdapter(menuDetailWorksAdapter);
        rcyRelated.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        menuDetailWorksAdapter.setNewData(works);
        menuDetailWorksAdapter.notifyDataSetChanged();
    }
}
