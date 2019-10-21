package com.MyUtilities;

import android.app.Activity;
import android.bluetooth.BluetoothAssignedNumbers;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class MySharedPreference {
    private static final MySharedPreference ourInstance = new MySharedPreference();

    public static MySharedPreference getInstance() {
        return ourInstance;
    }

    private MySharedPreference() {

    }

    // 값 불러오기
    protected Map<String, String> getPreferences(Activity mActivity){
        SharedPreferences pref = mActivity.getSharedPreferences("pref", MODE_PRIVATE);
        pref.getString("userId", "");
        pref.getString("userIdx", "");

        Map<String, String> result = new HashMap<>();
        result.put("userId", pref.getString("userId", ""));
        result.put("userIdx", pref.getString("userIdx", ""));

        return result;
    }

    // 값 저장하기
    protected boolean savePreferences(String userId, String userIdx, Activity mActivity){
        SharedPreferences pref = mActivity.getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("userId", userId);
        editor.putString("userIdx", userIdx);
        return editor.commit();

    }

    // 값(Key Data) 삭제하기
    protected void removePreferences(Activity mActivity){
        SharedPreferences pref = mActivity.getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("userId");
        editor.remove("userIdx");
        editor.commit();
    }

    // 값(ALL Data) 삭제하기
    protected void removeAllPreferences(Activity mActivity){
        SharedPreferences pref = mActivity.getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }


}
