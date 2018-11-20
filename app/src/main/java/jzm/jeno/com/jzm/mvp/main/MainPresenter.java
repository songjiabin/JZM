package jzm.jeno.com.jzm.mvp.main;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.fragment.DialogueFragment;
import jzm.jeno.com.jzm.fragment.HomePageFragment;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/15
 * desc   :
 * version: 1.0.0
 */

public class MainPresenter extends MainContract.Presenter {


    private MainModel mModel;
    private String[] mTitles;
    private List<Fragment> mFragmentList;

    public MainPresenter() {
        mModel = new MainModel();
    }


    @Override
    public void initFragment() {
        mFragmentList = new ArrayList<>();
        mTitles = ResUtils.getStringArray(R.array.main_tab_item);
        for (int i = 0; i < mTitles.length; i++) {
            switch (i) {
                case 0:
                    mFragmentList.add(HomePageFragment.newInstance(mTitles[i]));
                    break;
                case 1:
                    mFragmentList.add(DialogueFragment.newInstance(mTitles[i]));
                    break;
                case 2:
                case 3:
                    mFragmentList.add(HomePageFragment.newInstance(mTitles[i]));
                    break;
                default:
                    break;
            }
        }
        getView().setTab(mFragmentList, mTitles);
    }
}
