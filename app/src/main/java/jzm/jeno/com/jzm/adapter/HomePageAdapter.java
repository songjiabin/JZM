package jzm.jeno.com.jzm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * author : 宋佳
 * time   : 2018/11/15
 * desc   :
 * version: 1.0.0
 */

public class HomePageAdapter extends FragmentStatePagerAdapter {


    private String[] titles;
    private List<Fragment> fragmentList;

    public HomePageAdapter(FragmentManager fm) {
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


    public void setData(List<Fragment> fragmentList, String[] titles) {
        this.titles = titles;
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }

}
