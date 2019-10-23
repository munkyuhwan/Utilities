package com.MyUtilities;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.CustomList.CustomListView;
import com.MyUtilities.MyHttpRequest.EndPoints;

public class VolleyRequestAsync extends AsyncTask<Integer, Activity,Class> {
    private static VolleyRequestAsync ourInstance = new VolleyRequestAsync();

    public static VolleyRequestAsync getInstance() {
        if (ourInstance == null){ //if there is no instance available... create new one
            ourInstance = new VolleyRequestAsync();
        }
        return ourInstance;
    }

    private VolleyRequestAsync() {
    }
    private Activity mAcitvity;
    private int listID;
    private Class detailClass;


    private String classNum="1";

    public void init(Activity activity, int listID, Class detailClass, String classNum) {
        this.mAcitvity = activity;
        this.listID = listID;
        this.detailClass = detailClass;
        this.classNum = classNum;
    }


    @Override
    protected Class doInBackground(Integer... integers) {

        while(true) {

            Log.d("tag","========================== doing async ==========================");

            CustomListView listView =new CustomListView(this.mAcitvity);
            listView.init(this.listID, EndPoints.GET_LIST_URL, EndPoints.ORDER_LIST_TAG, this.detailClass, this.classNum);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }
}
