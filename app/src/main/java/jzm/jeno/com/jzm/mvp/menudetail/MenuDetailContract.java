package jzm.jeno.com.jzm.mvp.menudetail;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public interface MenuDetailContract {


    interface View extends BaseView {

    }


    interface Model {

    }


    abstract class Presenter extends BasePresenter<View> {

        public abstract void initData();
    }


}
