package jzm.jeno.com.jzm.mvp.menuitem;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import jzm.jeno.com.jzm.bean.JzmMenuBooksBean;
import jzm.jeno.com.jzm.bean.JzmMenuItemBean;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class MenuItemPresenter extends MenuItemContract.Presenter {


    private String mTitle;
    private MenuItemModel mMenuItemModel;
    private int currentPage;

    @Override
    public void initData(Bundle bundle) {
        mTitle = bundle.getString(Contracts.KEY_PARAMS_1);
        mMenuItemModel = new MenuItemModel(this, mTitle);
    }

    @Override
    public void process() {
        mMenuItemModel.loadData(currentPage);
    }

    @Override
    public void fail(String msg) {
        getView().showToast(msg);
    }


    @Override
    public void loadData(JzmMenuBooksBean jzmMenuBooksBean) {

        List<JzmMenuBooksBean.JzmMenuItemImgBooks> imgsList = jzmMenuBooksBean.getJzmMenuItemImgBooksList();
        List<JzmMenuBooksBean.JzmNenuItemContentBooks> contentList = jzmMenuBooksBean.getJzmNenuItemContentBooksList();


        if (imgsList.size() != contentList.size()) {
            return;
        }

        List<JzmMenuItemBean> jzmMenuItemBeanList = new ArrayList<>();
        for (int i = 0; i < imgsList.size(); i++) {
            JzmMenuItemBean jzmMenuItemBean = new JzmMenuItemBean();
            jzmMenuItemBean.setImg(imgsList.get(i).getImg());
            jzmMenuItemBean.setAuthor(contentList.get(i).getAuthor());
            jzmMenuItemBean.setContent(contentList.get(i).getContent());
            jzmMenuItemBean.setTitle(contentList.get(i).getTitle());
            jzmMenuItemBean.setLink(contentList.get(i).getLink());
            jzmMenuItemBeanList.add(jzmMenuItemBean);
        }

        getView().updateData(jzmMenuItemBeanList);

    }

    @Override
    public void pullToRefresh(boolean isLoadMore) {
        currentPage = isLoadMore ? ++currentPage : 0;
        process();
    }

    @Override
    public void requestError() {
        if (currentPage != 0) {
            getView().showLoadMoreRequestError();
        }
        if (currentPage == 0) {
            List<JzmMenuItemBean> jzmMenuItemBeanList = new ArrayList<>();
            getView().updateData(jzmMenuItemBeanList);
            getView().showRequestError();
        }
    }

}
