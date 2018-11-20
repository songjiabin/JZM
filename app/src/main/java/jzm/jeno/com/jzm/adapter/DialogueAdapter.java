package jzm.jeno.com.jzm.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jzm.jeno.com.jzm.ImageUtil.ImageLoader;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.bean.JzmDialogueBean;

/**
 * author : 宋佳
 * time   : 2018/11/20
 * desc   :
 * version: 1.0.0
 */

public class DialogueAdapter  extends BaseQuickAdapter<JzmDialogueBean.DialogueItemBean,BaseViewHolder>{


    public DialogueAdapter(  @Nullable List<JzmDialogueBean.DialogueItemBean> data) {
        super(R.layout.item_dialogue, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JzmDialogueBean.DialogueItemBean item) {
        ImageView dialogueImageView = helper.getView(R.id.dialogue_img);
        ImageLoader.loadImageByUrl(dialogueImageView.getContext(), dialogueImageView, "http:"+item.getImg());
    }
}
