package jzm.jeno.com.jzm.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.adapter.HomePageAdapter;
import jzm.jeno.com.jzm.base.BaseFragment;
import jzm.jeno.com.jzm.mvp.homepage.HomePageContract;
import jzm.jeno.com.jzm.mvp.homepage.HomePagePresenter;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/14
 * desc   :
 * version: 1.0.0
 */

public class HomePageFragment extends BaseFragment<HomePageContract.Presenter, HomePageContract.View> implements HomePageContract.View {


    @BindView(R.id.fg_home_page_tabLayout)
    protected TabLayout fg_home_page_tabLayout;
    @BindView(R.id.vp_home_page)
    protected ViewPager vp_home_page;

    private HomePageAdapter homePageAdapter;

    public static HomePageFragment newInstance(String category) {
        HomePageFragment homePageFragment = new HomePageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Contracts.KEY_PARAMS_1, category);
        return homePageFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPresenter.initFragment();
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        mPresenter.process();
    }

    @Override
    protected void initViewListener() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        homePageAdapter = new HomePageAdapter(getChildFragmentManager());
        vp_home_page.setAdapter(homePageAdapter);
        fg_home_page_tabLayout.setupWithViewPager(vp_home_page);

    }

    @Override
    public HomePageContract.Presenter createPresenter() {
        return new HomePagePresenter();
    }

    @Override
    public void setTab(List<HotPageItemFragment> fragmentList, String[] titles) {
        homePageAdapter.setData(fragmentList, titles);
        vp_home_page.setCurrentItem(0);
    }

    @Override
    public void setSelectPage(int item) {
        vp_home_page.setCurrentItem(item);
    }
}
