package jzm.jeno.com.jzm.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import jzm.jeno.com.jzm.R;
import jzm.jeno.com.jzm.base.BaseFragment;
import jzm.jeno.com.jzm.mvp.search.SearchContract;
import jzm.jeno.com.jzm.mvp.search.SearchPresenter;
import jzm.jeno.com.jzm.utils.Contracts;
import me.gujun.android.taggroup.TagGroup;

/**
 * author : 宋佳
 * time   : 2018/11/22
 * desc   :
 * version: 1.0.0
 */

public class SearchFragment extends BaseFragment<SearchContract.Presenter, SearchContract.View> implements SearchContract.View {


    @BindView(R.id.fg_search_edt_bg)
    public RelativeLayout mSearchEdtBackgrount;
    @BindView(R.id.fg_search_background_layout)
    public RelativeLayout mBackgroundLayout;
    @BindView(R.id.fg_search_edt)
    public MaterialEditText mEditText;
    @BindView(R.id.search_his_tags)
    public TagGroup mHistoryTagGroup;
    @BindView(R.id.fg_search_clean)
    public TextView mTextViewClean;
    @BindView(R.id.search_recommend_tags)
    public TagGroup mRecommendTagGroup;
    @BindView(R.id.search_recommend_title)
    public TextView mRecommendTitle;
    @BindView(R.id.search_history_title)
    public TextView mHistoryTitle;


    public static SearchFragment newInstance(String category) {
        SearchFragment searchFragment = new SearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Contracts.KEY_PARAMS_1, category);
        searchFragment.setArguments(bundle);
        return searchFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public SearchContract.Presenter createPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPresenter.initData();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initViewListener() {
        mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if (focus) {
                    mEditText.setHint("");
                }
                if (!focus) {
                    mEditText.setHint("搜索记录");
                }
            }
        });


        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    String searchTag = textView.getText().toString();
                    searchTag = searchTag.trim();

                    if (searchTag.length() > 0) {
                        mPresenter.addSearchTag(searchTag);
                        mEditText.setText("");
                    }
                    if (searchTag.length() <= 0) {
                        showToast("输入不能为空");
                    }
                }
                return false;
            }
        });

        mTextViewClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.clearTags();
            }
        });
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        mPresenter.process();
    }

    @Override
    public void setDefaultTags(String[] items) {
        mRecommendTagGroup.setTags(items);
    }

    @Override
    public void setSearchTags(String[] items) {
        mHistoryTagGroup.setTags(items);
        if (items.length > 0) {
            mHistoryTagGroup.removeViewAt(items.length - 1);
        }
    }
}
