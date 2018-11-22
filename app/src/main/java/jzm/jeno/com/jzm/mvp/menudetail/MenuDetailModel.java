package jzm.jeno.com.jzm.mvp.menudetail;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public class MenuDetailModel implements MenuDetailContract.Model {

    private MenuDetailPresenter mPresenter;

    public MenuDetailModel(MenuDetailPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }
}
