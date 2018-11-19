package jzm.jeno.com.jzm.mvp.homepage;

import java.util.ArrayList;
import java.util.List;

import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.fragment.HotPageItemFragment;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/16
 * desc   :
 * version: 1.0.0
 */

public class HomePagePresenter extends HomePageContract.Presenter {

    private HomePageModel mMode;
    private String[] mTitles;
    private List<HotPageItemFragment> mFragmentList;

    public HomePagePresenter() {
        mMode = new HomePageModel();
    }


    @Override
    public void initFragment() {
        mTitles = ResUtils.getStringArray(R.array.homepage_tab);
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            HotPageItemFragment hotPageItemFragment = HotPageItemFragment.newInstance(mTitles[i]);
            mFragmentList.add(hotPageItemFragment);
        }
        getView().setTab(mFragmentList, mTitles);
    }
}


