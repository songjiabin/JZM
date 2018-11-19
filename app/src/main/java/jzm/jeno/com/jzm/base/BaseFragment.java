package jzm.jeno.com.jzm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * author : 宋佳
 * time   : 2018/11/14
 * desc   :
 * version: 1.0.0
 */

public abstract class BaseFragment<P extends BasePresenter, V extends BaseView> extends Fragment implements BaseView {

    public String TAG = this.getClass().getSimpleName();

    public P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.onViewAttched(this);
        }
        initData(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
        initViewListener();
        process(savedInstanceState);
    }


    protected abstract int getLayoutId();

    public abstract P createPresenter();

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void process(Bundle savedInstanceState);

    protected abstract void initViewListener();

    protected abstract void initView(View view, Bundle savedInstanceState);


    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showLoading(String message) {

    }

    @Override
    public void dismissLoading() {

    }

}
