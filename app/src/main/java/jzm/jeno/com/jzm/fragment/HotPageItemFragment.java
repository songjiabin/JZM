package jzm.jeno.com.jzm.fragment;

import android.os.Bundle;
import android.view.View;

import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.base.BaseFragment;
import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/16
 * desc   :
 * version: 1.0.0
 */

public class HotPageItemFragment extends BaseFragment {


    public static HotPageItemFragment newInstance(String category) {
        HotPageItemFragment hotPageItemFragment = new HotPageItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Contracts.KEY_PARAMS, category);
        return hotPageItemFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hotpage_item;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void process(Bundle savedInstanceState) {

    }

    @Override
    protected void initViewListener() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
