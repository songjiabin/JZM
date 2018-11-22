package jzm.jeno.com.jzm.mvp.search;

import jzm.jeno.com.jzm.JzmApplication;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.utils.Contracts;
import jzm.jeno.com.jzm.utils.ResUtils;
import jzm.jeno.com.jzm.utils.SpfUtil;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public class SearchModel implements SearchContract.Model {

    private final SearchPresenter mSearchPresenter;

    public SearchModel(SearchPresenter searchPresenter) {
        this.mSearchPresenter = searchPresenter;
    }

    @Override
    public void getDefaultTags() {

        String[] items = ResUtils.getStringArray(R.array.recommend_tag_item);
        mSearchPresenter.setDefalutTag(items);

    }

    @Override
    public void addSearchTag(String tag) {

        String tags = (String) SpfUtil.getValue(JzmApplication.getContext(), Contracts.SEARCH_TAG, "");

        tags = tags + Contracts.SPLIT + tag;

        SpfUtil.saveValue(JzmApplication.getContext(), Contracts.SEARCH_TAG, tags);


        mSearchPresenter.refreshSearchTag(tags);


    }

    @Override
    public void getSearchTags() {
        String tags = (String) SpfUtil.getValue(JzmApplication.getContext(), Contracts.SEARCH_TAG, "");
        mSearchPresenter.refreshSearchTag(tags);
    }


    @Override
    public void clearSearchTag() {
        SpfUtil.clearValues(JzmApplication.getContext());
    }
}
