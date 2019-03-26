package com.easysoft.widget.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.easysoft.widget.edittextview.DelayListenerEditText;
import com.easysoft.widget.lib.R;
import com.easysoft.widget.utils.KeyboardUtils;
import com.easysoft.widget.utils.StringUtils;


public class SearchHeadView extends LinearLayout {

    View mBackLayout;

    View mCleanLayout;

    DelayListenerEditText mSearchEditText;

    Context mContext;
    private onTextChangerListener mListener;

    public SearchHeadView(Context context) {
        super(context);
        init(context);

    }

    public SearchHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }
    public void init(Context context){
        mContext=context;
        initUI();
        initListener();

    }

    private void initUI() {
      View rootView=  LayoutInflater.from(mContext).inflate(R.layout.view_searchhead, this, true);
        mBackLayout=rootView.findViewById(R.id.iv_back);
        mCleanLayout=rootView.findViewById(R.id.cleanLayout);
        mSearchEditText=(DelayListenerEditText)rootView.findViewById(R.id.searchEditText);

    }

    public void initListener(){
        DelayListenerEditText.onTextChangerListener
        mTextChangeListener=new DelayListenerEditText.onTextChangerListener() {
            @Override
            public void onTextChanger(String text) {
                if(mListener!=null){
                    mListener.onTextChanger(text);
                }
                if (StringUtils.isEmpty(text.trim())){
                    mCleanLayout.setVisibility(View.GONE);
                }else{
                    mCleanLayout.setVisibility(View.VISIBLE);
                }
            }
        };
        mSearchEditText.setOnTextChangerListener(mTextChangeListener);
        //清除点击
        mCleanLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchEditText.setText("");
            }
        });

        mSearchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    KeyboardUtils.closeKeybord(getContext(),mSearchEditText);
                    return true;
                }
                return false;
            }
        });

    }

    public View getBackLayout() {
        return mBackLayout;
    }

    public void setOnTextChangerListener(onTextChangerListener listener) {
        this.mListener = listener;
    }

    public interface onTextChangerListener {
        public void onTextChanger(String text);
    }

    public DelayListenerEditText getSearchEditText() {
        return mSearchEditText;
    }
}
