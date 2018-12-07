package jzm.jeno.com.jzm.activity;

import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import io.objectbox.Box;
import jzm.jeno.com.jzm.JzmApplication;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.base.BaseActivity;
import jzm.jeno.com.jzm.base.BasePresenter;
import jzm.jeno.com.jzm.bean.JzmLoginBean;

/**
 * author : 宋佳
 * time   : 2018/12/07
 * desc   :
 * version: 1.0.0
 */

public class ObjectBoxActivity extends BaseActivity {


    @BindView(R.id.btn_insert)
    protected Button btn_insert;


    @BindView(R.id.btn_delete)
    protected Button btn_delete;

    @BindView(R.id.btn_update)
    protected Button btn_update;

    @BindView(R.id.btn_query)
    protected Button btn_query;
    private Box<JzmLoginBean> objectBox;

    @Override
    protected int getLayouId() {
        return R.layout.activity_object_box;
    }

    @Override
    protected void initData() {
        objectBox = JzmApplication.getBoxStore().boxFor(JzmLoginBean.class);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void process() {
        Box<JzmLoginBean> objectBoxBean = JzmApplication.getBoxStore().boxFor(JzmLoginBean.class);

    }

    @Override
    protected void initViewListener() {

        //增
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JzmLoginBean jzmObjectBoxBean = new JzmLoginBean();
                jzmObjectBoxBean.setName("name1");
                jzmObjectBoxBean.setTitle("title1");
                objectBox.put(jzmObjectBoxBean);

            }
        });

        //删
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //改
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //查
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
