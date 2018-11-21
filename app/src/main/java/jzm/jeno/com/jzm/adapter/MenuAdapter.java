package jzm.jeno.com.jzm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import jzm.jeno.com.jzm.fragment.MenuItemFragment;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class MenuAdapter extends FragmentStatePagerAdapter {


    private List<MenuItemFragment> fragmentList;
    private String[] titles;

    public MenuAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList == null ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles == null ? "" : titles[position];
    }


    public void setData(List<MenuItemFragment> fragmentList, String[] titles) {
        this.fragmentList = fragmentList;
        this.titles = titles;
        notifyDataSetChanged();
    }

}
