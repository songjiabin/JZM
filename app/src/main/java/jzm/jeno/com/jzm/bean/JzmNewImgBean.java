package jzm.jeno.com.jzm.bean;

import java.util.List;

import me.ghui.fruit.Attrs;
import me.ghui.fruit.annotations.Pick;

/**
 * author : 宋佳
 * time   : 2018/11/20
 * desc   :
 * version: 1.0.0
 */

public class JzmNewImgBean {


    @Pick("div.item")
    private List<JzxNewImageItemBean> jzxNewImageItemBeanList;


    public List<JzxNewImageItemBean> getJzxNewImageItemBeanList() {
        return jzxNewImageItemBeanList;
    }

    public void setJzxNewImageItemBeanList(List<JzxNewImageItemBean> jzxNewImageItemBeanList) {
        this.jzxNewImageItemBeanList = jzxNewImageItemBeanList;
    }

    public static class JzxNewImageItemBean {
        @Pick(value = "img.fp-one-imagen", attr = Attrs.SRC)
        private String img;

        @Pick(value = "div.fp-one-cita > a")
        private String content;


        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
