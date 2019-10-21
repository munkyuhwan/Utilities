package com.MyUtilities;

import android.app.Activity;

import java.util.Map;

public class DoLogin  {
    private Activity mActivity;
    public DoLogin(Activity activity) {
        this.mActivity = activity;
    }

    public Map<String, String> loginCheck() {
        return MySharedPreference.getInstance().getPreferences(this.mActivity);
    }

    public boolean saveLoginInfo (String id, String idx, Activity activity) {
        return MySharedPreference.getInstance().savePreferences(id, idx, activity);
    }
/*
    @Override
    public Map<String, String> loginCheck() {
        return MySharedPreference.getInstance().getPreferences();
    }
*/

}
