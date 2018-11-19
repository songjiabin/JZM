package jzm.jeno.com.jzm.mvp.homepageitem;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmNewBean;
import jzm.jeno.com.jzm.http.ApiMethods;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/19
 * desc   :
 * version: 1.0.0
 */

public class HomePageItemModel implements HomePageItemContract.Model {

    private HomePageItemContract.Presenter mPresenter;

    public HomePageItemModel(HomePageItemContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }


    /**
     * 加载数据
     */
    @Override
    public void loadData(int page) {
        ApiMethods.getJzmNewInfo(page, new Observer<JzmNewBean>() {


            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JzmNewBean jzmNewBean) {
                if (jzmNewBean == null) {
                    mPresenter.fail(ResUtils.getString(R.string.load_fail));
                }
                if (jzmNewBean != null) {
                    mPresenter.loadData(jzmNewBean);
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
