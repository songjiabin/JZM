package jzm.jeno.com.jzm.bean;

/**
 * author : 宋佳
 * time   : 2018/11/21
 * desc   :
 * version: 1.0.0
 */

public class JzmMenuItemBean {

    private String img;
    private String content;
    private String author;
    private String title;
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return "http:" + img;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
