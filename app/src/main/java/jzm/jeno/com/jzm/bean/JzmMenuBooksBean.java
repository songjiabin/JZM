package jzm.jeno.com.jzm.bean;

import java.util.List;

import me.ghui.fruit.Attrs;
import me.ghui.fruit.annotations.Pick;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class JzmMenuBooksBean {

    @Pick(value = "div.views-field-tid")
    private List<JzmMenuItemImgBooks> jzmMenuItemImgBooksList;


    @Pick(value = "div.views-field-phpcode")
    private List<JzmNenuItemContentBooks> jzmNenuItemContentBooksList;


    public List<JzmMenuItemImgBooks> getJzmMenuItemImgBooksList() {
        return jzmMenuItemImgBooksList;
    }

    public void setJzmMenuItemImgBooksList(List<JzmMenuItemImgBooks> jzmMenuItemImgBooksList) {
        this.jzmMenuItemImgBooksList = jzmMenuItemImgBooksList;
    }

    public List<JzmNenuItemContentBooks> getJzmNenuItemContentBooksList() {
        return jzmNenuItemContentBooksList;
    }

    public void setJzmNenuItemContentBooksList(List<JzmNenuItemContentBooks> jzmNenuItemContentBooksList) {
        this.jzmNenuItemContentBooksList = jzmNenuItemContentBooksList;
    }

    public static class JzmMenuItemImgBooks {
        @Pick(value = "img", attr = Attrs.SRC)
        private String img;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }



    public static class JzmNenuItemContentBooks{
        @Pick("span.xqallarticletilelinkspan > a")
        private String title;
        @Pick("div.views-field-phpcode > a")
        private String author;
        @Pick("div.xqagepawirdesc")
        private String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }



}
