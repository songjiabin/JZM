package jzm.jeno.com.jzm.bean;

import java.io.Serializable;
import java.util.List;

import me.ghui.fruit.annotations.Pick;

/**
 * author : 宋佳
 * time   : 2018/11/19
 * desc   : 句子迷 最新 url : https://www.juzimi.com/new?page=1
 * version: 1.0.0
 */

public class JzmNewBean implements Serializable {


    @Pick("div.views-field-phpcode")
    private List<JzmNewItemBean> newItemBeanList;

    public List<JzmNewItemBean> getNewItemBeanList() {
        return newItemBeanList;
    }

    public void setNewItemBeanList(List<JzmNewItemBean> newItemBeanList) {
        this.newItemBeanList = newItemBeanList;
    }

    public static class JzmNewItemBean {
        @Pick("a.xlistju")
        private String content;


        @Pick("div.xqjulistwafo > a")
        private String author;

        @Pick("span.views-field-field-oriarticle-value > a")
        private String from;


        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }


}
