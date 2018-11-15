package jzm.jeno.com.jzm.base;

import android.os.Bundle;

/**
 * author : 宋佳
 * time   : 2018/11/15
 * desc   :
 * version: 1.0.0
 */

public abstract class BasePresenter<V extends BaseView> {

    protected V view;

    public BasePresenter() {
    }

    public V getView() {
        return view;
    }

    public void onViewAttched(V view) {
        this.view = view;
    }

    public void onViewDetached() {
        view = null;
    }

    public void destroy() {
    }

    public void onSaveInstanceState(Bundle outState) {
    }
}
