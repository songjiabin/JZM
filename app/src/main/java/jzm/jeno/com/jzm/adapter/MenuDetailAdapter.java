package jzm.jeno.com.jzm.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmMenuDetailBean;

/**
 * author : 宋佳
 * time   : 2018/11/23
 * desc   :
 * version: 1.0.0
 */

public class MenuDetailAdapter extends BaseQuickAdapter<JzmMenuDetailBean.JzmMenuDetailItemBean, BaseViewHolder> {


    public MenuDetailAdapter(@Nullable List<JzmMenuDetailBean.JzmMenuDetailItemBean> data) {
        super(R.layout.laout_menu_detail, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JzmMenuDetailBean.JzmMenuDetailItemBean item) {
        String title = item.getTitle() == null ? "未知" : item.getTitle();
        helper.setText(R.id.search_item_title, title);

        String content = getFormatItemContent(item);

        helper.setText(R.id.search_item_content, content);

        String likeCount = item.getLike() == null ? "0" : item.getLike();
        helper.setText(R.id.search_item_like_count, likeCount);

        String writer = item.getAuthor() == null ? "佚名" : item.getAuthor();
        helper.setText(R.id.search_item_writer, writer);

        String publisher = item.getFrom() == null ? "佚名" : item.getFrom();
        helper.setText(R.id.search_item_publisher, publisher);


    }


    public String getFormatItemContent(JzmMenuDetailBean.JzmMenuDetailItemBean item) {
        String content = item.getContent().trim();
        String regex = ".*[a-zA-Z]+.*";
        if (!content.matches(regex)) {
            content = content.replace(" ", "\n");
        }
        return content;
    }
}
