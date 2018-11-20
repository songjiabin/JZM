package jzm.jeno.com.jzm.mvp.homepageitem;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;
import jzm.jeno.com.jzm.bean.JzmNewBean;

/**
 * author : 宋佳
 * time   : 2018/11/19
 * desc   :
 * version: 1.0.0
 */

public interface HomePageItemContract {


    interface View extends BaseView {
        void showMessage(String message);

        void updateData(List<JzmNewBean.JzmNewItemBean> sentences);


        void refreshImgInfo(String url);

        void regreshImgTagInfo(String url);



        void showRequestError();

        void showLoadMoreRequestError();
    }


    interface Model {
        public void loadData(int page);


        public void loadPictureData();


    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void initData(Bundle bundle);

        public abstract void process(Bundle bundle);

        public abstract Context getContext();


        public abstract void fail(String message);


        public abstract void loadData(JzmNewBean jzmNewBean);


        public abstract void requestError();


        /**
         * Description: 刷新或加载请求
         */
        public abstract void pullToRefresh(boolean isLoadMore);


        public abstract void loadPictureImgInfo(String url);


        public abstract void loadPictureImgTag(String text);


    }


}
