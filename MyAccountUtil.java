package com.MyUtilities;

import android.app.Activity;

import com.MyUtilities.MySharedPreference;

import java.util.Map;

public class MyAccountUtil {
    private Activity mActivity;
    public MyAccountUtil(Activity activity) {
        this.mActivity = activity;
    }

    public Map<String, String> getMyId() {
        return MySharedPreference.getInstance().getPreferences(mActivity);
    }
}
