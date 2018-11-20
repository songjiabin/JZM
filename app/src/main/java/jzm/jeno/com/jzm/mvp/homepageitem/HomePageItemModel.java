package jzm.jeno.com.jzm.mvp.homepageitem;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmNewBean;
import jzm.jeno.com.jzm.bean.JzmNewImgBean;
import jzm.jeno.com.jzm.http.ApiMethods;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/19
 * desc   :
 * version: 1.0.0
 */

public class HomePageItemModel implements HomePageItemContract.Model {

    private final String category;
    private HomePageItemContract.Presenter mPresenter;

    private int current_position = 0;

    public HomePageItemModel(HomePageItemContract.Presenter mPresenter, String category) {
        this.mPresenter = mPresenter;
        this.category = category;
        if (category.equals("最新上传")) {
            current_position = 0;
        } else if (category.equals("今日热门")) {
            current_position = 1;
        } else if (category.equals("今日推荐")) {
            current_position = 2;
        } else if (category.equals("最受欢迎")) {
            current_position = 3;
        }

    }


    /**
     * 加载数据
     */
    @Override
    public void loadData(int page) {
        if (category.equals("最新上传")) {
            ApiMethods.getJzmNewInfo(page, observer);
        } else if (category.equals("今日热门")) {
            ApiMethods.getJzmTodayInfo(page, observer);
        } else if (category.equals("今日推荐")) {
            ApiMethods.getJzmRecommendInfo(page, observer);
        } else if (category.equals("最受欢迎")) {
            ApiMethods.getJzmTotallikeInfo(page, observer);
        }
    }

    /**
     * 加载图片
     */
    @Override
    public void loadPictureData() {
        ApiMethods.getJzmNewImgInfo(new Observer<JzmNewImgBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JzmNewImgBean jzmNewBean) {
                if (jzmNewBean == null) {
                    mPresenter.fail(ResUtils.getString(R.string.load_fail));
                }
                if (jzmNewBean != null && jzmNewBean.getJzxNewImageItemBeanList() != null) {


                    mPresenter.loadPictureImgInfo(jzmNewBean.getJzxNewImageItemBeanList().get(current_position).getImg());
                    mPresenter.loadPictureImgTag(jzmNewBean.getJzxNewImageItemBeanList().get(current_position).getContent());


                    //将访问得到的数据  保存到数据库中


                }
            }

            @Override
            public void onError(Throwable e) {
                String message = e.getMessage();

                if (message.contains("404")) {
                    mPresenter.fail(ResUtils.getString(R.string.load_end));
                } else {
                    mPresenter.fail(e.getMessage());
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }


    private Observer<JzmNewBean> observer = new Observer<JzmNewBean>() {
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
    };


}
