package jzm.jeno.com.jzm.mvp.dialogue;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmDialogueBean;
import jzm.jeno.com.jzm.http.ApiMethods;
import jzm.jeno.com.jzm.utils.ResUtils;

/**
 * author : 宋佳
 * time   : 2018/11/16
 * desc   :
 * version: 1.0.0
 */

public class DialogueModel implements DialogueContract.Model {

    private DialoguePresenter mPresenter;

    public DialogueModel(DialogueContract.Presenter presenter) {
        mPresenter = (DialoguePresenter) presenter;
    }

    @Override
    public void process(int page) {
        ApiMethods.getJzmDialogueInfo(page, new Observer<JzmDialogueBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JzmDialogueBean jzmDialogueBean) {
                if (jzmDialogueBean == null) {
                    mPresenter.fail(ResUtils.getString(R.string.load_fail));
                }
                if (jzmDialogueBean != null) {
                    mPresenter.loadData(jzmDialogueBean);
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
