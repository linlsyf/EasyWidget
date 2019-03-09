package com.easysoft.widget.statusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class SoftKeyBoardSatusView extends LinearLayout {

	int scroll_dx;

	int screenHeight;
	private final int CHANGE_SIZE = 100;

	View mBottomView;

	View mContentLayout;

	public SoftKeyBoardSatusView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	public void init(int screenHeight, View mContentLayout, View mBottomView){
		this.screenHeight=screenHeight;
		this.mContentLayout=mContentLayout;
		this.mBottomView =mBottomView;
//		setSoftKeyBoardListener(this);
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		if (oldw == 0 || oldh == 0)
			return;

//		if ( oldh == 0){
//			oldw=w;
//			oldh=h+mBottomView.getMeasuredHeight();
//		}
		if ((mContentLayout!=null&& mBottomView !=null)|boardListener != null) {
			if (boardListener!=null){

				boardListener.keyBoardStatus(w, h, oldw, oldh);
			}
			if (oldw != 0 && h - oldh < -CHANGE_SIZE) {
				if (boardListener!=null){

					boardListener.keyBoardVisable(Math.abs(h - oldh));
				}
				keyBoardVisable(Math.abs(h - oldh));
			}

			if (oldw != 0 && h - oldh > CHANGE_SIZE) {
				if (boardListener!=null){

					boardListener.keyBoardInvisable(Math.abs(h - oldh));
				}
				keyBoardInvisable(Math.abs(h - oldh));
			}
		}
	}

	public void keyBoardInvisable(int move) {
		if (mContentLayout!=null){

			mContentLayout.scrollBy(0, -scroll_dx);
		}
	}

	public void keyBoardStatus(int w, int h, int oldw, int oldh) {

	}
	public void keyBoardVisable(int move) {
		if (mContentLayout!=null&& mBottomView !=null){

			int[] location = new int[2];
			mBottomView.getLocationOnScreen(location);
			int btnToBottom = screenHeight - location[1] - mBottomView.getHeight();
			scroll_dx = btnToBottom > move ? 0 : move - btnToBottom;
			mContentLayout.scrollBy(0, scroll_dx);
		}
	}

	public interface SoftkeyBoardListener {

		public void keyBoardStatus(int w, int h, int oldw, int oldh);

		public void keyBoardVisable(int move);

		public void keyBoardInvisable(int move);
	}

	SoftkeyBoardListener boardListener;

	public void setSoftKeyBoardListener(SoftkeyBoardListener boardListener) {
		this.boardListener = boardListener;
	}
}
