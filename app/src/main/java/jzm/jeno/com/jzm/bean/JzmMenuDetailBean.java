package jzm.jeno.com.jzm.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import me.ghui.fruit.Attrs;
import me.ghui.fruit.annotations.Pick;

/**
 * author : 宋佳
 * time   : 2018/11/23
 * desc   :
 * version: 1.0.0
 */

public class JzmMenuDetailBean implements Parcelable {


    @Pick(value = "div.views-field-phpcode")
    private List<JzmMenuDetailItemBean> jzmMenuDetailItemBeanList;


    @Pick(value = "span.xqwridesczuopinlinkspan")
    private List<String> works;


    @Pick(value = "div.wridesccon")
    private String introduction;


    @Pick(value = "div.views-field-tid > img", attr = Attrs.SRC)
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<JzmMenuDetailItemBean> getJzmMenuDetailItemBeanList() {
        return jzmMenuDetailItemBeanList;
    }

    public void setJzmMenuDetailItemBeanList(List<JzmMenuDetailItemBean> jzmMenuDetailItemBeanList) {
        this.jzmMenuDetailItemBeanList = jzmMenuDetailItemBeanList;
    }

    public List<String> getWorks() {
        return works;
    }

    public void setWorks(List<String> works) {
        this.works = works;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public static class JzmMenuDetailItemBean implements Parcelable {
        @Pick(value = "a.xlistju")
        private String content;


        @Pick(value = "div.xqjulistwafo > a")
        private String author;


        @Pick(value = "span.views-field-field-oriarticle-value > a")
        private String title;


        @Pick(value = "a.flag-action")
        private String like;


        @Pick(value = "div.views-field-xqname > a")
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.content);
            dest.writeString(this.author);
            dest.writeString(this.title);
            dest.writeString(this.like);
            dest.writeString(this.from);
        }

        public JzmMenuDetailItemBean() {
        }

        protected JzmMenuDetailItemBean(Parcel in) {
            this.content = in.readString();
            this.author = in.readString();
            this.title = in.readString();
            this.like = in.readString();
            this.from = in.readString();
        }

        public static final Creator<JzmMenuDetailItemBean> CREATOR = new Creator<JzmMenuDetailItemBean>() {
            @Override
            public JzmMenuDetailItemBean createFromParcel(Parcel source) {
                return new JzmMenuDetailItemBean(source);
            }

            @Override
            public JzmMenuDetailItemBean[] newArray(int size) {
                return new JzmMenuDetailItemBean[size];
            }
        };
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.jzmMenuDetailItemBeanList);
        dest.writeStringList(this.works);
        dest.writeString(this.introduction);
        dest.writeString(this.link);
    }

    public JzmMenuDetailBean() {
    }

    protected JzmMenuDetailBean(Parcel in) {
        this.jzmMenuDetailItemBeanList = new ArrayList<JzmMenuDetailItemBean>();
        in.readList(this.jzmMenuDetailItemBeanList, JzmMenuDetailItemBean.class.getClassLoader());
        this.works = in.createStringArrayList();
        this.introduction = in.readString();
        this.link = in.readString();
    }

    public static final Parcelable.Creator<JzmMenuDetailBean> CREATOR = new Parcelable.Creator<JzmMenuDetailBean>() {
        @Override
        public JzmMenuDetailBean createFromParcel(Parcel source) {
            return new JzmMenuDetailBean(source);
        }

        @Override
        public JzmMenuDetailBean[] newArray(int size) {
            return new JzmMenuDetailBean[size];
        }
    };
}
