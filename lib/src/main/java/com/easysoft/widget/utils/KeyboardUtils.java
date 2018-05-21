package com.easysoft.widget.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by lindanghong on 2018/5/21.
 */

public class KeyboardUtils {
    public static void closeKeybord(Context mContext, EditText mEditText) {
        InputMethodManager imm = (InputMethodManager)mContext.getSystemService("input_method");
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

}
