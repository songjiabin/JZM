package jzm.jeno.com.jzm.mvp.search;

import android.text.TextUtils;

import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public class SearchPresenter extends SearchContract.Presenter {


    private SearchModel mModel;

    @Override
    public void initData() {
        mModel = new SearchModel(this);
    }

    @Override
    public void setDefalutTag(String[] tags) {
        getView().setDefaultTags(tags);

    }

    @Override
    public void process() {
        mModel.getDefaultTags();
        mModel.getSearchTags();
    }

    @Override
    public void addSearchTag(String tag) {
        mModel.addSearchTag(tag);
    }

    @Override
    public void refreshSearchTag(String tags) {

        if (!TextUtils.isEmpty(tags)) {
            String[] tagsArray = tags.split(Contracts.SPLIT);

            //倒序
            //对数组进行倒序
            for (int start = 0, end = tagsArray.length - 1; start < end; start++, end--) {
                String temp = tagsArray[end];
                tagsArray[end] = tagsArray[start];
                tagsArray[start] = temp;
            }

            getView().setSearchTags(tagsArray);
        } else {
            getView().setSearchTags(new String[]{});
        }


    }

    @Override
    public void clearTags() {
        mModel.clearSearchTag();
        mModel.getSearchTags();
    }


}
