package jzm.jeno.com.jzm.mvp.menu;

import java.util.List;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;
import jzm.jeno.com.jzm.fragment.MenuItemFragment;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public interface MenuContract {


    interface View extends BaseView {

        void setTab(List<MenuItemFragment> fragmentList, String[] titles);

    }


    abstract class Presenter extends BasePresenter<View> {
        public abstract void initData();
    }


    interface Model {

    }

}
