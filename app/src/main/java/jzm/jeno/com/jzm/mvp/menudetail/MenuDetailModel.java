package jzm.jeno.com.jzm.mvp.menudetail;

import android.os.Bundle;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmMenuDetailBean;
import jzm.jeno.com.jzm.http.ApiMethods;
import jzm.jeno.com.jzm.utils.Contracts;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public class MenuDetailModel implements MenuDetailContract.Model {

    private MenuDetailPresenter mPresenter;

    public MenuDetailModel(MenuDetailPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void loadData(String articleId, int page) {
        ApiMethods.getjzmMenuDetailInfo(articleId, page, new Observer<JzmMenuDetailBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JzmMenuDetailBean jzmMenuDetailBean) {
                if (jzmMenuDetailBean == null) {
                    mPresenter.fail(ResUtils.getString(R.string.load_fail));
                }
                if (jzmMenuDetailBean != null) {
                    mPresenter.setData(jzmMenuDetailBean);

                    Bundle bundle = new Bundle();
                    bundle.putString(Contracts.ARTICLE_PAGE_URL, jzmMenuDetailBean.getLink());
                    bundle.putString(Contracts.ARTICLE_PAGE_INTRO, jzmMenuDetailBean.getIntroduction());

                    bundle.putStringArrayList(Contracts.ARTICLE_PAGE_RELATED, (ArrayList<String>) jzmMenuDetailBean.getWorks());


                    mPresenter.showArticleHead(bundle);


                }
            }

            @Override
            public void onError(Throwable e) {
                String message = e.getMessage();
                if (message.contains("404")) {
                    mPresenter.fail(ResUtils.getString(R.string.load_end));
                } else {
                    mPresenter.fail(e.getMessage());
                    mPresenter.requestError();
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
