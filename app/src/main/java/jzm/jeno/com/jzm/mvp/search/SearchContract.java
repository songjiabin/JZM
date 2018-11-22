package jzm.jeno.com.jzm.mvp.search;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public interface SearchContract {


    interface View extends BaseView {

        void setDefaultTags(String[] items);


        void setSearchTags(String[] items);

    }

    interface Model {

        void getDefaultTags();

        void addSearchTag(String tag);



        void clearSearchTag();

        void getSearchTags();

    }


    abstract class Presenter extends BasePresenter<View> {

        public abstract void initData();

        public abstract void setDefalutTag(String[] tags);

        public abstract void process();

        public abstract void addSearchTag(String tag);

        public abstract void refreshSearchTag(String tags);

        public abstract void clearTags();

    }


}

