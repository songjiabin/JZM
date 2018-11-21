package jzm.jeno.com.jzm.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jzm.jeno.com.jzm.ImageUtil.ImageLoader;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmMenuItemBean;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class MenuItemAdapter extends BaseQuickAdapter<JzmMenuItemBean, BaseViewHolder> {


    public MenuItemAdapter(@Nullable List<JzmMenuItemBean> data) {
        super(R.layout.item_nemu, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JzmMenuItemBean item) {
        helper.setText(R.id.category_item_title, item.getTitle());
        helper.setText(R.id.category_item_author, item.getAuthor());
        helper.setText(R.id.category_item_content, item.getContent());
        ImageView imageView = helper.getView(R.id.category_item_img);

        ImageLoader.loadImageByUrl(imageView.getContext(), imageView, item.getImg());
    }
}
