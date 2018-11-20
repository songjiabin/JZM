package jzm.jeno.com.jzm.mvp.dialogue;

import java.util.List;

import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.base.BaseView;
import jzm.jeno.com.jzm.bean.JzmDialogueBean;

/**
 * author : 宋佳
 * time   : 2018/11/16
 * desc   :
 * version: 1.0.0
 */

public interface DialogueContract {

    interface View extends BaseView {

        void loadData(List<JzmDialogueBean.DialogueItemBean> jzmDialogueBean);
        void showRequestError();
        void showLoadMoreRequestError();
    }


    abstract class Presenter extends BasePresenter<View> {
        public abstract void initData();

        //开始请求数据
        public abstract void process();


        public abstract void fail(String message);


        public abstract void loadData(JzmDialogueBean jzmDialogueBean);


        public abstract void requestError();



        public abstract void pullToRefresh(boolean isLoadMore);

    }

    interface Model {
        void process(int page);
    }


}
