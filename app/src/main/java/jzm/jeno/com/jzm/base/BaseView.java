package jzm.jeno.com.jzm.base;

/**
 * author : 宋佳
 * time   : 2018/11/15
 * desc   :
 * version: 1.0.0
 */

public interface BaseView {

    void showToast(String message);

    void showLoading(String resourceId);

    void dismissLoading();

}
