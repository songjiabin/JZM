package jzm.jeno.com.jzm.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.adapter.MenuAdapter;
import jzm.jeno.com.jzm.base.BaseFragment;
import jzm.jeno.com.jzm.mvp.menu.MenuContract;
import jzm.jeno.com.jzm.mvp.menu.MenuPresenter;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class MenuFragment extends BaseFragment<MenuContract.Presenter, MenuContract.View> implements MenuContract.View {


    @BindView(R.id.vp_menu_content)
    protected ViewPager vp_menu_content;

    @BindView(R.id.tablayout_mune)
    protected TabLayout tablayout_mune;


    private MenuAdapter menuAdapter;


    public static MenuFragment newInstance(String category) {
        MenuFragment menuFragment = new MenuFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Contracts.KEY_PARAMS_1, category);
        menuFragment.setArguments(bundle);
        return menuFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_menu;
    }

    @Override
    public MenuContract.Presenter createPresenter() {
        return new MenuPresenter();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        menuAdapter = new MenuAdapter(getChildFragmentManager());
        vp_menu_content.setAdapter(menuAdapter);
        tablayout_mune.setupWithViewPager(vp_menu_content);
        mPresenter.initData();
    }

    @Override
    protected void initViewListener() {

    }

    @Override
    protected void process(Bundle savedInstanceState) {

    }

    @Override
    public void setTab(List<MenuItemFragment> fragmentList, String[] titles) {
        menuAdapter.setData(fragmentList,titles);
        vp_menu_content.setCurrentItem(0);
    }
}
