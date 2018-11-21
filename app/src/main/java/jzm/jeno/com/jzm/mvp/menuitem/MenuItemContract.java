package jzm.jeno.com.jzm.mvp.menuitem;

import android.os.Bundle;

import java.util.List;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;
import jzm.jeno.com.jzm.bean.JzmMenuBooksBean;
import jzm.jeno.com.jzm.bean.JzmMenuItemBean;


/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public interface MenuItemContract {


    interface View extends BaseView {

        void updateData(List<JzmMenuItemBean> sentences);
        void showLoadMoreRequestError();

        void showRequestError();
    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void initData(Bundle bundle);

        public abstract void process();


        /**
         * Description: 请求失败
         */
        public abstract void fail(String msg);

        public abstract void requestError();


        public abstract void loadData(JzmMenuBooksBean jzmMenuBooksBean);


        public abstract void pullToRefresh(boolean isLoadMore);


    }


    interface Model {
        public void loadData(int page);
    }

}
