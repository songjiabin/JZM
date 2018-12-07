package jzm.jeno.com.jzm.bean;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * author : 宋佳
 * time   : 2018/12/07
 * desc   :
 * version: 1.0.0
 */

@Entity
public class JzmLoginBean {

    @Id
    private long id;

    private String name;
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
