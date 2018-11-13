package jzm.jeno.com.jzm.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import butterknife.BindView;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @BindView(R.id.nv_left_content)
    protected NavigationView nv_left_content;


    @BindView(R.id.dl_main)
    protected DrawerLayout dl_main;

    @Override
    protected int getLayouId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        nv_left_content.setEnabled(true);
    }


}
