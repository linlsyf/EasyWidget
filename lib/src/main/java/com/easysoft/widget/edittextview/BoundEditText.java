package com.easysoft.widget.edittextview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


public class BoundEditText extends android.support.v7.widget.AppCompatEditText {
	private Drawable dRight;
	private Drawable dleft;
	private Rect rBounds;
	private boolean hasFocus;
	private boolean cursorInEnd=false;
	private View bingView ;
	private Context context;

	private boolean isEdit = true;
	private cleanCallback callback;
	private boolean isshowDrawableAlways=false;
	private boolean isshowDrawable=true;

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public BoundEditText(Context paramContext) {
		super(paramContext);
		this.context = paramContext;
		initEditText();
	}

	public BoundEditText(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		this.context = paramContext;
		initEditText();
	}

	public BoundEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
		this.context = paramContext;
		initEditText();
	}

	private void initEditText() {
		
		setEditTextDrawable();

		addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable paramEditable) {

			}

			public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
			}

			public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
				BoundEditText.this.setEditTextDrawable();
			}
		});

		setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				BoundEditText.this.hasFocus = hasFocus;
					setEditTextDrawable();
				
			}
		});
	}

	public void onFocusChange(View v, boolean hasFocus){
		BoundEditText.this.hasFocus = hasFocus;
		setEditTextDrawable();
	}

	public void setIsShowDrawable(boolean isshowDrawable) {
		this.isshowDrawable = isshowDrawable;
	}

	private void setEditTextDrawable() {
		 
		String text=getText().toString();
		if (text.length() > 0 && hasFocus == true&&isshowDrawable) {
			setCompoundDrawables(this.dleft, null, this.dRight, null);
		} else {
			setCompoundDrawables(null, null, null, null);
		}
		if (isshowDrawableAlways&&isshowDrawable) {
			setCompoundDrawables(this.dleft, null, this.dRight, null);
		}
	}

	protected void finalize() throws Throwable {
		super.finalize();
		this.dRight = null;
		this.rBounds = null;
	}


	public boolean onTouchEvent(MotionEvent paramMotionEvent) {
		if (!isEdit) {
			return false;
		}

		if ((this.dRight != null) && hasFocus == true) {
			this.rBounds = this.dRight.getBounds();
			int i = (int) paramMotionEvent.getRawX();

			if (i > (getRight() - this.rBounds.width())) {
				setText("");
				paramMotionEvent.setAction(MotionEvent.ACTION_CANCEL);
				if (callback != null) {
					callback.onClickClean();
				}
			}
		}
		return super.onTouchEvent(paramMotionEvent);
	}

	public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3,
                                     Drawable paramDrawable4) {
		if (paramDrawable3 != null)
			this.dRight = paramDrawable3;
		if (paramDrawable1 != null) {
			this.dleft = paramDrawable1;
		}
		super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
	}

	public void showkeyboard(boolean Focusable) {
		if (Focusable == true) {
			InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
		} else {
			InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(getWindowToken(), 0);

		}

	}

	public interface cleanCallback {

		public void onClickClean();
	}

	public void setcleanCallback(cleanCallback callback) {
		this.callback = callback;
	}
	public void setShowDrawablesAlways(boolean isshowDrawableAlways){
		this.isshowDrawableAlways=isshowDrawableAlways;
		setEditTextDrawable();
	}
	
	
	 @Override
	    protected void onSelectionChanged(int selStart, int selEnd) {
	        
		if (cursorInEnd & selEnd < getText().length()) {
			setSelection(getText().length());
		} else {

			super.onSelectionChanged(selStart, selEnd);
		}

	    }
	 

	 public void setCursorInEnd(Boolean iscursorInLast){
		 this.cursorInEnd=iscursorInLast;
	 }
	 

	 public void setBingView(View v){
		 this.bingView=v;
	 }
}
