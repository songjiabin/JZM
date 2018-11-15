package jzm.jeno.com.jzm.mvp.main;

import android.support.v4.app.Fragment;

import java.util.List;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;

/**
 * author : 宋佳
 * time   : 2018/11/15
 * desc   :
 * version: 1.0.0
 */

public interface MainContract {

    interface View extends BaseView {
        void setTab(List<Fragment> fragmentList, String[] titles);
    }


    abstract class Presenter extends BasePresenter<View> {
        public abstract void initFragment();
    }

    interface Model {

    }

}
