package jzm.jeno.com.jzm.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * author : 宋佳
 * time   : 2018/11/13
 * desc   :
 * version: 1.0.0
 */

public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends AppCompatActivity implements BaseView {

    public P mPresenter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayouId());
        //隐藏状态栏
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);





        ButterKnife.bind(this);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.onViewAttched(this);
        }
        initData();
        initView();
        initViewListener();
        process();
    }


    protected abstract int getLayouId();


    protected abstract void initData();


    protected abstract void initView();

    protected abstract void process();


    protected abstract void initViewListener();



    public abstract P createPresenter();

    @Override
    public void showToast(String message) {

    }


    @Override
    public void showLoading(String message) {

    }

    @Override
    public void dismissLoading() {

    }


}
