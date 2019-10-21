package com.MyUtilities;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashJson {


     public static final Map<String,String> jsonToHash(final JSONObject jsonObject) {

        Map<String,String> params = new HashMap<String, String>();

         final Iterator itr = jsonObject.keys();

         while (itr.hasNext()) {

             try {
                 String keyValue = itr.next().toString();
                 params.put(keyValue, jsonObject.getString(keyValue) );
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }

         return params;
    }

    public static final ArrayList<HashMap<String,String>> jsonArrayToHash(final JSONArray jsonArray) {
        ArrayList<HashMap<String,String>> list = new ArrayList();

        for (int i=0; i<jsonArray.length();i++) {
            HashMap<String,String> params = new HashMap<String, String>();

            final Iterator itr;
            try {
                JSONObject job = jsonArray.getJSONObject(i);
                itr = job.keys();
                while (itr.hasNext()) {
                    try {
                        String keyValue = itr.next().toString();
                        Log.e("VLUES",keyValue+":"+job.getString(keyValue));
                        params.put(keyValue, job.getString(keyValue));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                list.add(params);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }



        return list;
    }


    public static final JSONObject hashToJson(Map<String,String> mapHash) {
         return new JSONObject();
    }


}
