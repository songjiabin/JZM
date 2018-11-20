package jzm.jeno.com.jzm.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.adapter.MainAdapter;
import jzm.jeno.com.jzm.base.BaseActivity;
import jzm.jeno.com.jzm.mvp.main.MainContract;
import jzm.jeno.com.jzm.mvp.main.MainPresenter;

public class MainActivity extends BaseActivity<MainContract.Presenter, MainContract.View> implements MainContract.View {


    @BindView(R.id.nv_left_content)
    protected NavigationView nv_left_content;

    @BindView(R.id.dl_main)
    protected DrawerLayout dl_main;

    @BindView(R.id.vp_content)
    protected ViewPager vp_content;


    @BindView(R.id.tablayout_main)
    protected TabLayout tablayout_main;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;


    private MainAdapter homePageAdapter;

    @Override
    protected int getLayouId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        homePageAdapter = new MainAdapter(getSupportFragmentManager());
        vp_content.setAdapter(homePageAdapter);
        tablayout_main.setupWithViewPager(vp_content);
        mPresenter.initFragment();


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initView() {
        toolbar.setTitle("句子迷");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    public void setTab(List<Fragment> fragmentList, String[] titles) {
        homePageAdapter.setData(fragmentList, titles);
        vp_content.setCurrentItem(0);
    }
}
