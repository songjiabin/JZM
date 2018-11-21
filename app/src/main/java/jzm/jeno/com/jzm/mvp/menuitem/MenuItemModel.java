package jzm.jeno.com.jzm.mvp.menuitem;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmMenuBooksBean;
import jzm.jeno.com.jzm.http.ApiMethods;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class MenuItemModel implements MenuItemContract.Model {


    private MenuItemPresenter mPresenter;
    private String titlle;

    public MenuItemModel(MenuItemPresenter mPresenter, String title) {
        this.mPresenter = mPresenter;
        this.titlle = title;
    }

    @Override
    public void loadData(int page) {
        if (titlle.equals("书籍")) {
            ApiMethods.getJzmMenuBooksInfo(page, observer);
        } else if (titlle.equals("电影")) {
            ApiMethods.getJzmMenuMoviesInfo(page, observer);
        } else if (titlle.equals("散文")) {
            ApiMethods.getJzmMenuProsesInfo(page, observer);
        } else if (titlle.equals("动漫")) {
            ApiMethods.getJzmMenuAnimesInfo(page, observer);
        } else if (titlle.equals("电视剧")) {
            ApiMethods.getJzmMenuTvInfo(page, observer);
        } else if (titlle.equals("古诗词")) {
            ApiMethods.getJzmMenuGuShiInfo(page, observer);
        }
    }


    private Observer<JzmMenuBooksBean> observer = new Observer<JzmMenuBooksBean>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(JzmMenuBooksBean jzmMenuBooksBean) {
            if (jzmMenuBooksBean == null) {
                mPresenter.fail(ResUtils.getString(R.string.load_fail));
            }
            if (jzmMenuBooksBean != null && jzmMenuBooksBean.getJzmMenuItemImgBooksList() != null && jzmMenuBooksBean.getJzmNenuItemContentBooksList() != null) {
                mPresenter.loadData(jzmMenuBooksBean);
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
    };

}

