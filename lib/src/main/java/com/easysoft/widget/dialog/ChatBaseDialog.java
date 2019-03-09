package com.easysoft.widget.dialog;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.easysoft.widget.lib.R;



public class ChatBaseDialog {
    private Dialog dialog;

    private View view;

    private TextView title;

    private TextView bodyTV;

    private TextView ok;

    private TextView cancel;

    private FrameLayout customLayout;
    private LinearLayout btnLayout;
    private LinearLayout mRootLayout;
    private View titleLine;
    private View flLine;
    private View btnLine;
    private boolean cancelByBack;
    int mListDialogAnim= R.style.dialogAnim;
    int mListGravity= Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL;
    Context context;

    public ChatBaseDialog(Context context, boolean cancelable, boolean cancelOnTouchOutside) {
        this.context=context;
        dialog = new Dialog(context, R.style.DialogStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(cancelOnTouchOutside);

        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        setCancelByBack(cancelable);
        initView(dialog.getContext());
        initListener();
    }


    public ChatBaseDialog(Context context, boolean cancelable, boolean cancelOnTouchOutside,
                          boolean titleVisible, String title,
                          boolean okVisible, View.OnClickListener okListener,
                          boolean cancelVisible, View.OnClickListener cancelListener){
        this(context, cancelable, cancelOnTouchOutside);
        setTitle(title);
        setOKListener(okListener);
        setCancelListener(cancelListener);
        if(!titleVisible){
            this.title.setVisibility(View.GONE);
        }
        if(!okVisible){
            setOKVisible(View.GONE);
        }
        if(!cancelVisible){
            setCancelVisible(View.GONE);
        }
    }

    private void initView(Context context){
        view = View.inflate(context, R.layout.chat_view_message_resend_ask, null);

        title = (TextView) view.findViewById(R.id.resend_ask_title);

        ok = (TextView) view.findViewById(R.id.resend_ask_confirm);

        cancel = (TextView) view.findViewById(R.id.resend_ask_cancel);

        customLayout = (FrameLayout) view.findViewById(R.id.resend_ask_custom_fl);

        btnLayout = (LinearLayout) view.findViewById(R.id.resend_ask_btn_ll);

        mRootLayout = (LinearLayout) view.findViewById(R.id.rootLayout);

        bodyTV = new TextView(context);

        titleLine = view.findViewById(R.id.resend_ask_title_line);
        flLine = view.findViewById(R.id.resend_ask_fl_line);
        btnLine = view.findViewById(R.id.resend_ask_btn_line);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = context.getResources().getDisplayMetrics().widthPixels * 7 / 10 ;
        params.height = LayoutParams.WRAP_CONTENT;
        dialog.setContentView(view, params);
    }

    private void initListener(){

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
        });
        dialog.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface arg0, int keycode, KeyEvent event) {
                if(keycode == KeyEvent.KEYCODE_BACK){
                    if(event.getAction() == KeyEvent.ACTION_UP && cancelByBack){
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                            }
                        });
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void setBtnVisible(){
        view.post(new Runnable() {

            @Override
            public void run() {
                if(!ok.isShown() && !cancel.isShown()){
                    setBtnVisible(View.GONE);
                } else {
                    setBtnVisible(View.VISIBLE);
                }
            }
        });
    }

    private void setBtnLineVisible(){
        view.post(new Runnable() {
            @Override
            public void run() {
                if(ok.isShown() && cancel.isShown()){
                    btnLine.setVisibility(View.VISIBLE);
                } else {
                    btnLine.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setFLLineVisible(){
        view.post(new Runnable() {
            @Override
            public void run() {
                if(customLayout.isShown() && btnLayout.isShown()){
                    flLine.setVisibility(View.VISIBLE);
                } else {
                    flLine.setVisibility(View.GONE);
                }
            }
        });
    }

    public void setCancelByBack(boolean cancel){
        cancelByBack = cancel;
    }

    public void setTitle(CharSequence title) {
        this.title.setText(title);
    }

    public void setTitleBold(boolean bold){
        this.title.getPaint().setFakeBoldText(bold);
    }

    public void setTitleSize(float size){
        title.setTextSize(size);
    }

    public void setTitleColor(int color){
        title.setTextColor(color);
    }

    public void setTitleGravity(int gravity){
        title.setGravity(gravity);
    }

    public void setTitleVisible(int visible){
        title.setVisibility(visible);
        titleLine.setVisibility(visible);
    }

    public void setTitleLineVisible(int visible){
        titleLine.setVisibility(visible);
    }

    public void setOKVisible(int visible){
        ok.setVisibility(visible);
        setBtnLineVisible();
        setBtnVisible();
    }

    public void setCancelVisible(int visible){
        cancel.setVisibility(visible);
        setBtnLineVisible();
        setBtnVisible();
    }

    public  void setRootLayoutBg(int resId){
        mRootLayout.setBackgroundResource(resId);
    }


    public void setOKListener(final View.OnClickListener okListener){
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(okListener != null){
                    okListener.onClick(ok);
                }
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
        });
    }

    public void setCancelListener(final View.OnClickListener cancelListener){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(cancelListener != null){
                    cancelListener.onClick(cancel);
                }
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
        });
    }

    public TextView getOkView(){
        return ok;
    }

    public TextView getCancelView(){
        return cancel;
    }

    public void setBodyView(View view) {
        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        customLayout.addView(view);
        customLayout.setVisibility(View.VISIBLE);
        setFLLineVisible();
    }

    public void setBodyText(String text){
        bodyTV.setText(text);
        bodyTV.setPadding(25, 50, 25, 50);
        bodyTV.setGravity(Gravity.CENTER_HORIZONTAL);
        setBodyView(bodyTV);
    }

    public void setBodyText(String text, float size){
        bodyTV.setTextSize(size);
        setBodyText(text);
    }

    public void setBodyViewVisible(int visible){
        customLayout.setVisibility(visible);
        setFLLineVisible();
    }

    public void setLineVisible(int visible){
        titleLine.setVisibility(visible);
        flLine.setVisibility(visible);
        btnLine.setVisibility(visible);
    }

    public void setLineWidth(int width){
        LinearLayout.LayoutParams titleP = (LinearLayout.LayoutParams) titleLine.getLayoutParams();
        titleP.height = width;
        titleLine.setLayoutParams(titleP);
        LinearLayout.LayoutParams flP = (LinearLayout.LayoutParams) flLine.getLayoutParams();
        flP.height = width;
        flLine.setLayoutParams(flP);
        LinearLayout.LayoutParams btnP = (LinearLayout.LayoutParams) btnLine.getLayoutParams();
        btnP.height = width;
        btnLine.setLayoutParams(btnP);
    }

    public void setLineColor(int color){
        titleLine.setBackgroundColor(color);
        flLine.setBackgroundColor(color);
        btnLine.setBackgroundColor(color);
    }

    public void setBtnVisible(int visible){
        btnLayout.setVisibility(visible);
        setFLLineVisible();
    }

    public void show(){
        if(!dialog.isShowing()){
            dialog.show();
        }
    }

    public void dismiss(){
        if(dialog.isShowing()){
            dialog.dismiss();
        }
    }

    public void cancel(){
        if(dialog.isShowing()){
            dialog.cancel();
        }
    }

    public boolean isShowing(){
        return dialog == null ? false : dialog.isShowing();
    }


    public void setOnShowListener( OnShowListener onShowListener){
        if (dialog!=null) {
            dialog.setOnShowListener(onShowListener);
        }
    }


    public void setListDialogAnim(int mListDialogAnim) {
        this.mListDialogAnim = mListDialogAnim;
    }


    public void setListDialogGravity(int listGravity) {
        this. mListGravity=listGravity;
    }


    public void showListDialog(){

        setTitleVisible(View.GONE);
        setBtnVisible(View.GONE);
        setRootLayoutBg(R.drawable.transparent);

        Window mWindow = dialog.getWindow();
        if (mListDialogAnim!=0){
            mWindow.setWindowAnimations(mListDialogAnim);
        }


        int width=context.getResources().getDisplayMetrics().widthPixels *9/ 10 ;
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width =width;
        params.height = LayoutParams.WRAP_CONTENT;
        params.gravity= Gravity.BOTTOM;
        dialog.setContentView(view, params);

        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(mListGravity);

        dialog.show();
    }


    public void setSoftInputCoverResize(){
        if (dialog!=null) {
            dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        }

    }
    public Dialog getDialog() {
        return dialog;
    }
}
