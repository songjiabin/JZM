package jzm.jeno.com.jzm.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jzm.jeno.com.jzm.R;

/**
 * author : 宋佳
 * time   : 2018/11/23
 * desc   :
 * version: 1.0.0
 */

public class MenuDetailWorksAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public MenuDetailWorksAdapter(@Nullable List<String> data) {
        super(R.layout.item_menu_details_work, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (item != null) {
            helper.setText(R.id.related_title, item);
        }
    }
}
