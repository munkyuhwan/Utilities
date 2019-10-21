package com.MyUtilities;

import android.app.Activity;
import android.app.ProgressDialog;

public class SetSpinner {

    private Activity mCurrentActivity;

    private ProgressDialog pd;

    public SetSpinner(Activity currentActivity) {
        this.mCurrentActivity = currentActivity;
    }


    public void init() {
        mCurrentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pd = new ProgressDialog(mCurrentActivity);
            }
        });
    }

    public void startProgress() {
        init();

        mCurrentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.setMessage("진행중 입니다..");

                pd.show();

            }
        });


    }

    public void stopProgress() {
        mCurrentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
            }
        });
    }



}
