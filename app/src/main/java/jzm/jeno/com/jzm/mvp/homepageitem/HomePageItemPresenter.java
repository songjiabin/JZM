package jzm.jeno.com.jzm.mvp.homepageitem;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import jzm.jeno.com.jzm.bean.JzmNewBean;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/19
 * desc   :
 * version: 1.0.0
 */

public class HomePageItemPresenter extends HomePageItemContract.Presenter {


    private HomePageItemModel mModel;
    private int mCurrentPage;
    private Context mContext;

    public HomePageItemPresenter(Context context) {
        this.mContext = context;
    }

    @Override
    public void initData(Bundle bundle) {
        mModel = new HomePageItemModel(this,bundle.getString(Contracts.KEY_PARAMS_1));
    }

    @Override
    public void process(Bundle bundle) {
        String title = bundle.getString(Contracts.KEY_PARAMS_1);
        mModel.loadData(mCurrentPage);
        mModel.loadPictureData();
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void fail(String message) {
        getView().showMessage(message);
    }

    @Override
    public void loadData(JzmNewBean jzmNewBean) {
        getView().updateData(jzmNewBean.getNewItemBeanList());

    }

    @Override
    public void requestError() {
        if (mCurrentPage != 0) {
            getView().showLoadMoreRequestError();
        }
        if (mCurrentPage == 0) {
            List<JzmNewBean.JzmNewItemBean> sentencesItemList = new ArrayList<>();
            getView().updateData(sentencesItemList);
            getView().showRequestError();
        }
    }

    @Override
    public void pullToRefresh(boolean isLoadMore) {
        mCurrentPage = isLoadMore ? ++mCurrentPage : 0;
        mModel.loadData(mCurrentPage);
        mModel.loadPictureData();
    }

    @Override
    public void loadPictureImgInfo(String url) {
        getView().refreshImgInfo(url);
    }

    @Override
    public void loadPictureImgTag(String text) {
        getView().regreshImgTagInfo(text);
    }


}
