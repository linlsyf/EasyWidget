package com.easysoft.widget.process;



import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.easysoft.widget.lib.R;


public class ProgressHUD extends Dialog {
	

	boolean hasinit =false;

	boolean isshowing=false;
	public ProgressHUD(Context context) {
		super(context, R.style.ProgressHUD);
	}

	public ProgressHUD(Context context, int theme) {
		
		super(context, theme);
	}


	public void onWindowFocusChanged(boolean hasFocus){
		ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }
	
	public void setMessage(CharSequence message) {
		if(message != null && message.length() > 0) {
			findViewById(R.id.message).setVisibility(View.VISIBLE);
			TextView txt = (TextView)findViewById(R.id.message);
			txt.setText(message);
			txt.invalidate();
		}
		else {
			this.dismiss();
		}
	}
	
	@Override
	public void show() {
		isshowing=true;
		super.show();
	}
	@Override
	public void dismiss() {
		isshowing=false;
		super.dismiss();
	}
	@Override
	public boolean isShowing() {
		return isshowing;
//		return super.isShowing();
	}

	public  ProgressHUD showDialog(Context context, CharSequence message, boolean indeterminate, boolean cancelable,
                                   OnCancelListener cancelListener, OnKeyListener onKeyListener ) {
		
		if (hasinit) {
			return this;
		}
			
		setTitle("");
		setContentView(R.layout.progress_hud);
		getWindow().getAttributes().gravity= Gravity.CENTER;
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.dimAmount=0.2f;
		getWindow().setAttributes(lp); 
	
		if(message == null || message.length() == 0) {
			findViewById(R.id.message).setVisibility(View.GONE);
		} else {
			TextView txt = (TextView)findViewById(R.id.message);
			txt.setText(message);
		}
		setCancelable(cancelable);//默认可以按返回键取消
		setCanceledOnTouchOutside(cancelable);
		setOnCancelListener(cancelListener);
		setOnKeyListener(onKeyListener);
		show();
		hasinit = true;

		return this;
	}	
	
	

	public static ProgressHUD show(Context context, CharSequence message, boolean indeterminate, boolean cancelable,
                                   OnCancelListener cancelListener, OnKeyListener onKeyListener ) {
		ProgressHUD dialog = new ProgressHUD(context,R.style.ProgressHUD);
		dialog.setTitle("");
		dialog.setContentView(R.layout.progress_hud);
		if(message == null || message.length() == 0) {
			dialog.findViewById(R.id.message).setVisibility(View.GONE);
		} else {
			TextView txt = (TextView)dialog.findViewById(R.id.message);
			txt.setText(message);
		}
		dialog.setCancelable(cancelable);//默认可以按返回键取消
		dialog.setCanceledOnTouchOutside(indeterminate);
		dialog.setOnCancelListener(cancelListener);
		dialog.setOnKeyListener(onKeyListener);
		dialog.getWindow().getAttributes().gravity= Gravity.CENTER;
		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.dimAmount=0.2f;
		dialog.getWindow().setAttributes(lp); 
		//dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		dialog.show();
		return dialog;
	}	
	public static ProgressHUD show(Context context, CharSequence message, boolean indeterminate, boolean cancelable, boolean issingle,
                                   OnCancelListener cancelListener, OnKeyListener onKeyListener ) {
		ProgressHUD dialog = new ProgressHUD(context,R.style.ProgressHUD);
		dialog.setTitle("");
		dialog.setContentView(R.layout.progress_hud);
		if(message == null || message.length() == 0) {
			dialog.findViewById(R.id.message).setVisibility(View.GONE);
		} else {
			TextView txt = (TextView)dialog.findViewById(R.id.message);
			txt.setText(message);
		}
		dialog.setCancelable(cancelable);//默认可以按返回键取消
		dialog.setCanceledOnTouchOutside(cancelable);
		dialog.setOnCancelListener(cancelListener);
		dialog.setOnKeyListener(onKeyListener);
		dialog.getWindow().getAttributes().gravity= Gravity.CENTER;
		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.dimAmount=0.2f;
		dialog.getWindow().setAttributes(lp); 
		//dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		dialog.show();
		return dialog;
	}	
	
	
	

	public static ProgressHUD show(Context context, CharSequence message, boolean indeterminate, boolean cancelable,
                                   OnCancelListener cancelListener, OnKeyListener onKeyListener, int  ContentViewId) {
		ProgressHUD dialog = new ProgressHUD(context,R.style.ProgressHUD);
		dialog.setTitle("");
		
		dialog.setContentView(ContentViewId);
		if(message == null || message.length() == 0) {
			dialog.findViewById(R.id.message).setVisibility(View.GONE);
		} else {
			TextView txt = (TextView)dialog.findViewById(R.id.message);
			txt.setText(message);
		}
		dialog.setCancelable(cancelable);//默认可以按返回键取消
		dialog.setCanceledOnTouchOutside(cancelable);
		dialog.setOnCancelListener(cancelListener);
		dialog.setOnKeyListener(onKeyListener);
		dialog.getWindow().getAttributes().gravity= Gravity.CENTER;
		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.dimAmount=0.2f;
		dialog.getWindow().setAttributes(lp); 
		//dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		dialog.show();
		return dialog;
	}	
	public static ProgressHUD show(Context context, CharSequence message) {
		ProgressHUD dialog = new ProgressHUD(context,R.style.ProgressHUD);
		dialog.setTitle("");
		dialog.setContentView(R.layout.progress_hud);
		if(message == null || message.length() == 0) {
			dialog.findViewById(R.id.message).setVisibility(View.GONE);
		} else {
			TextView txt = (TextView)dialog.findViewById(R.id.message);
			txt.setText(message);
		}
		
		dialog.getWindow().getAttributes().gravity= Gravity.CENTER;
		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.dimAmount=0.2f;
		dialog.getWindow().setAttributes(lp); 
		//dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		dialog.show();
		return dialog;
	}	
	
}
