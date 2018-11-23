package jzm.jeno.com.jzm.mvp.menudetail;

import android.os.Bundle;

import jzm.jeno.com.jzm.bean.JzmMenuDetailBean;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public class MenuDetailPresenter extends MenuDetailContract.Presenter {

    private MenuDetailModel mModel;
    private int mCurrentPage;
    private String articleId;

    @Override
    public void initData() {
        mModel = new MenuDetailModel(this);
    }

    @Override
    public void process(String articleId) {
        this.articleId=articleId;
        mModel.loadData(articleId, mCurrentPage);
    }

    @Override
    public void setData(JzmMenuDetailBean jzmMenuDetailBean) {
        getView().updateData(jzmMenuDetailBean.getJzmMenuDetailItemBeanList());
    }

    @Override
    public void loadMore() {
        mCurrentPage += 1;
        process(articleId);
    }

    @Override
    public void requestError() {
        if (mCurrentPage != 0) {
            getView().showLoadMoreRequestError();
        }

        if (mCurrentPage == 0) {
            getView().showRequestError();
        }
    }

    @Override
    public void fail(String msg) {
        getView().showMessage(msg);
    }

    @Override
    public void showArticleHead(Bundle bundle) {
        getView().updateHead(bundle);
    }
}
