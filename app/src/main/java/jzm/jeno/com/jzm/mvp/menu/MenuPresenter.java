package jzm.jeno.com.jzm.mvp.menu;


import java.util.ArrayList;

import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.fragment.MenuItemFragment;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class MenuPresenter extends MenuContract.Presenter {

    private MenuModel mMode;
    private String[] mTitles;
    private ArrayList<MenuItemFragment> mFragmentList;

    @Override
    public void initData() {
        mMode = new MenuModel();
        initFragment();
    }


    private void initFragment() {
        mTitles = ResUtils.getStringArray(R.array.menu_tab);
        mFragmentList = new ArrayList<MenuItemFragment>();
        for (int i = 0; i < mTitles.length; i++) {
            mFragmentList.add(MenuItemFragment.newInstance(mTitles[i]));
        }

        //通知View 进行更新
        getView().setTab(mFragmentList, mTitles);
    }


}
