package jzm.jeno.com.jzm.mvp.dialogue;

import java.util.ArrayList;
import java.util.List;

import jzm.jeno.com.jzm.bean.JzmDialogueBean;

/**
 * author : 宋佳
 * time   : 2018/11/16
 * desc   :
 * version: 1.0.0
 */

public class DialoguePresenter extends DialogueContract.Presenter {


    private DialogueModel mModel;
    private int currentPage;


    @Override
    public void initData() {
        mModel = new DialogueModel(this);
    }

    @Override
    public void process() {
        mModel.process(currentPage);
    }

    @Override
    public void fail(String message) {
        getView().showToast(message);
    }

    @Override
    public void loadData(JzmDialogueBean jzmDialogueBean) {
        getView().loadData(jzmDialogueBean.getDialogueItemBeanList());
    }

    @Override
    public void requestError() {
        if (currentPage != 0) {
            getView().showLoadMoreRequestError();
        }
        if (currentPage == 0) {
            List<JzmDialogueBean.DialogueItemBean> dialogueItemList = new ArrayList<>();
            getView().loadData(dialogueItemList);
            getView().showRequestError();
        }
    }

    @Override
    public void pullToRefresh(boolean isLoadMore) {
        currentPage = isLoadMore ? ++currentPage : 0;
        process();
    }
}


