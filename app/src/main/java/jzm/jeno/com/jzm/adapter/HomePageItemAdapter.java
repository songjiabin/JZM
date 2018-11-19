package jzm.jeno.com.jzm.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmNewBean;

/**
 * author : 宋佳
 * time   : 2018/11/19
 * desc   :
 * version: 1.0.0
 */

public class HomePageItemAdapter extends BaseQuickAdapter<JzmNewBean.JzmNewItemBean, BaseViewHolder> {


    public HomePageItemAdapter( @Nullable List<JzmNewBean.JzmNewItemBean> data) {
        super(R.layout.item_homepage_new, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JzmNewBean.JzmNewItemBean item) {
        String author = item.getAuthor();
        String content = item.getContent();
        String from = item.getFrom();


        helper.setText(R.id.item_article, from == null ? "未知" : from);

        helper.setText(R.id.item_writer, author == null ? "未知" : author);

        helper.setText(R.id.item_content, getFormatItemContent(item) == null ? "未知" : getFormatItemContent(item));


    }




    public   String getFormatItemContent(JzmNewBean.JzmNewItemBean item) {
        String content = item.getContent().trim();
        String regex = ".*[a-zA-Z]+.*";
        if (!content.matches(regex)) {
            content = content.replace(" ", "\n");
        }
        return content;
    }
}
