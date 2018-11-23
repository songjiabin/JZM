package jzm.jeno.com.jzm.mvp.menudetail;

import android.os.Bundle;

import java.util.List;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;
import jzm.jeno.com.jzm.bean.JzmMenuDetailBean;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public interface MenuDetailContract {


    interface View extends BaseView {

        void updateData(List<JzmMenuDetailBean.JzmMenuDetailItemBean> jzmMenuDetailItemBeans);


        void showLoadMoreRequestError();

        void showRequestError();

        void showMessage(String msg);

        void updateHead(Bundle bundle);
    }


    interface Model {

        void loadData(String articleId, int page);

    }


    abstract class Presenter extends BasePresenter<View> {

        public abstract void initData();

        public abstract void process(String articleId);

        public abstract void setData(JzmMenuDetailBean jzmMenuDetailBean);


        public abstract void loadMore();

        public abstract void requestError();

        public abstract void fail(String msg);

        public abstract void showArticleHead(Bundle bundle);
    }


}
