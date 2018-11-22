package jzm.jeno.com.jzm.activity;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.base.BaseActivity;
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

    @Override
    protected int getLayouId() {
        return R.layout.activity_menu_detail;
    }

    @Override
    protected void initData() {
        mLink = getIntent().getExtras().getString(Contracts.KEY_PARAMS_1);
        mTitle = getIntent().getExtras().getString(Contracts.KEY_PARAMS_2);
        mPresenter.initData();
    }

    @Override
    protected void initView() {
        mCollLayout.setTitle(mTitle);
        mCollLayout.setExpandedTitleColor(this.getResources().getColor(android.R.color.white));
        mCollLayout.setExpandedTitleTypeface(Typeface.create("bold", Typeface.BOLD));
        mCollLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(mToolbar);


        mProgressBar.getIndeterminateDrawable()
                .setColorFilter(ContextCompat.getColor(this, R.color.orange), PorterDuff.Mode.MULTIPLY);
        mProgressBar.show();
    }

    @Override
    public MenuDetailContract.Presenter createPresenter() {
        return new MenuDetailPresenter();
    }


}
