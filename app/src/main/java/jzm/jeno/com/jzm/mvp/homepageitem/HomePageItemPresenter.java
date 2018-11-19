package jzm.jeno.com.jzm.mvp.homepageitem;

import android.content.Context;
import android.os.Bundle;

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
    private int mCurrentPage  ;
    private Context mContext;

    public HomePageItemPresenter(Context context) {
        mModel = new HomePageItemModel(this);
        this.mContext = context;
    }

    @Override
    public void initData(Bundle bundle) {
        String title = bundle.getString(Contracts.KEY_PARAMS);
        mModel.loadData(mCurrentPage);
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

    }

    @Override
    public void pullToRefresh(boolean isLoadMore) {
        mCurrentPage = isLoadMore ? ++mCurrentPage : 0;
        mModel.loadData(mCurrentPage);
    }


}
