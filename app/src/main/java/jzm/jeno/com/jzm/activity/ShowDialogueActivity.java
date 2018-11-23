package jzm.jeno.com.jzm.activity;

import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;
import jzm.jeno.com.jzm.ImageUtil.ImageLoader;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.base.BaseActivity;
import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.utils.Contracts;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class ShowDialogueActivity extends BaseActivity {


    @BindView(R.id.show_dialogue_photoview)
    protected PhotoView show_dialogue_photoview;

    @Override
    protected int getLayouId() {
        return R.layout.activity_show_dialogue;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        ImageLoader.loadImageByUrl(this, show_dialogue_photoview, getIntent().getStringExtra(Contracts.KEY_PARAMS_1));
    }

    @Override
    protected void process() {

    }

    @Override
    protected void initViewListener() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
