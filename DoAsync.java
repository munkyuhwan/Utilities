package com.MyUtilities;

import android.app.Activity;
import android.os.AsyncTask;

import com.CustomList.CustomListView;

public class DoAsync extends AsyncTask<Void, Void, Void> {
    private CustomListView listView;
    private Activity mActivity;

    private int listID;
    private String requestURL;
    private String returnTAG;
    private Class intentClass;

    public DoAsync(Activity activity, int listID, String requestURL, String returnTAG, Class intentClass) {
        this.mActivity = activity;
        this.listID = listID;
        this.requestURL = requestURL;
        this.returnTAG = returnTAG;
        this.intentClass = intentClass;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        while(true) {
            listView = new CustomListView(this.mActivity);
            listView.init(this.listID, this.requestURL, this.returnTAG, this.intentClass);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }
    }


}
