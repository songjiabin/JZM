package jzm.jeno.com.jzm.mvp.menudetail;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public class MenuDetailPresenter extends MenuDetailContract.Presenter {

    private MenuDetailModel mModel;

    @Override
    public void initData() {
        mModel = new MenuDetailModel(this);
    }




}
