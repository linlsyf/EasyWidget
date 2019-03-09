package com.easysoft.widget.edittextview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
public class DelayListenerEditText extends EditText {
//    private String TAG = "MyEditText";  
    private static final int MSGCODE = 0x12121212;  
      private mTextWatcher textWatcher = new mTextWatcher();  
    private String text;
    private int msgCount = 0;
    long delayMillis = 900;

	public DelayListenerEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.addTextChangedListener(textWatcher);
	}
  
    private onTextChangerListener listener = null;  
  
    public void setOnTextChangerListener(onTextChangerListener listener) {  
        this.listener = listener;  
    }  
  
    public interface onTextChangerListener {  
        public void onTextChanger(String text);
    }  
  
    private class mTextWatcher implements TextWatcher {
        public void afterTextChanged(Editable s) {
            text = s.toString();  
              msgCount++;  
              Message msg = new Message();
            msg.what = MSGCODE;  
            mHandler.sendMessageDelayed(msg, delayMillis);  
        }

		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
		}

		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
		}  
  
    }  
    

    public void setDelayMillis(long delayMillis) {
		this.delayMillis = delayMillis;
	}

    public void resetListener(String text) {
        removeTextChangedListener(textWatcher);  
        setText(text);  
        setSelection(text.length());
        addTextChangedListener(textWatcher);  
    }  
  
    /**监听 延迟处理文字*/
    Handler mDelayedHandler = new Handler();
  
    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == MSGCODE) {  
                if (msgCount == 1) {  
                    if (listener != null) {  
                        listener.onTextChanger(text); 
                        resetListener(text);
                    }  
                    msgCount = 0;  
                } else {  
                    msgCount--;  
                }  
  
            }  
        }  
    };  
  
}  