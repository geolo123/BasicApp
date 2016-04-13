package com.common.control;

import android.widget.Toast;

import com.common.EasyApplication;

/**
 * author meikoz on 2016/4/13.
 * email  meikoz@126.com
 */
public class ToastTip {

    static Toast mToast;

    public static void show(CharSequence message) {
        if (mToast == null) mToast.cancel();
        int duration = Toast.LENGTH_SHORT;
        if (message.length() > 10) {
            duration = Toast.LENGTH_LONG;
        }
        mToast = Toast.makeText(EasyApplication.getInstance(), message, duration);
        mToast.show();
    }
}
