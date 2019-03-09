package com.easysoft.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;


public class BaseCustomView extends LinearLayout {
	protected Context mContext;
	protected View rootView;
	
	public BaseCustomView(Context context) {
		super(context,null);
//		this.BaseCustomView(context,null);
	}
	

	public BaseCustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		this.setOrientation(VERTICAL);
		initUI(context);
	}

	@SuppressWarnings("unchecked")
	public final <E extends View> E getViewById(int id) {
		
		if(rootView != null){
			return (E) rootView.findViewById(id);
		}
		return null;
	}

	public void initUI(Context context) {

	}
	public void initData() {

	}

	public void initListener(OnClickListener listener) {
		
	}
}
