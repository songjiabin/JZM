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

public class JzmDialogueBean {


    @Pick(value = "div.views-field-phpcode")
    private List<DialogueItemBean> dialogueItemBeanList;

    public List<DialogueItemBean> getDialogueItemBeanList() {
        return dialogueItemBeanList;
    }

    public void setDialogueItemBeanList(List<DialogueItemBean> dialogueItemBeanList) {
        this.dialogueItemBeanList = dialogueItemBeanList;
    }

    public static class DialogueItemBean {
        @Pick(value = "img.chromeimg",attr = Attrs.SRC)
        private String img;

        public String getImg() {
            return "http:"+img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

}
