package jzm.jeno.com.jzm.mvp.homepage;

import java.util.List;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;
import jzm.jeno.com.jzm.fragment.HotPageItemFragment;

/**
 * author : 宋佳
 * time   : 2018/11/16
 * desc   :
 * version: 1.0.0
 */

public interface HomePageContract {

    interface View extends BaseView {

        void setTab(List<HotPageItemFragment> fragmentList, String[] titles);

        void setSelectPage(int item);

    }


    abstract class Presenter extends BasePresenter<View> {
        public abstract void initFragment();

        public abstract void process();
    }

    interface Model {

    }


}
