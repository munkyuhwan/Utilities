package com.MyUtilities.MyHttpRequest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.MyUtilities.MyHttpRequest.Interfaces.MainInterface;
import com.MyUtilities.SetSpinner;
import com.Variables.BasicVariables;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.app.Activity.RESULT_OK;

public class VolleyRequestClass {


    private Activity mCurrentActivity;
    private MainInterface mCurrentInterface;
    private Bitmap bitmap;

    public VolleyRequestClass(Activity currentActivity, MainInterface currentInterface) {
        this.mCurrentActivity = currentActivity;
        this.mCurrentInterface = currentInterface;
    }

    public void multipartVolley(final Bitmap bitmap, final Map<String, String> jsonDatas, final String dataRequestURL) {
        //final SetSpinner setSpinner = new SetSpinner(mCurrentActivity);
        //startSpinner(dataRequestURL, setSpinner);

        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.GET, dataRequestURL,
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {

                        //stopSpinner(dataRequestURL, setSpinner);

                        try {
                            JSONArray obj = new JSONArray(new String(response.data));
                            mCurrentInterface.responseResult(obj,jsonDatas.get("tag"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            errorToast();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //stopSpinner(dataRequestURL, setSpinner);

                        error.printStackTrace();
                        errorToast();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params = jsonDatas;
                return params;
            }

            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                if (bitmap != null) {
                    long imagename = System.currentTimeMillis();
                    params.put("pic", new DataPart(imagename + ".png", getFileDataFromDrawable(bitmap)));
                }
                return params;
            }
        };
        Volley.newRequestQueue(mCurrentActivity).add(volleyMultipartRequest);
    }

    private void startSpinner(String dataRequestURL, SetSpinner setSpinner) {
        if (isSpinner(dataRequestURL)) {
            setSpinner.startProgress();
        }
    }
    private void stopSpinner(String dataRequestURL, SetSpinner setSpinner) {
        if (setSpinner != null && isSpinner(dataRequestURL)) {
            setSpinner.stopProgress();
        }
    }

    List<String> spinnerAccept = new ArrayList<>();
    private boolean isSpinner(String urls) {
        spinnerAccept.add(EndPoints.REQUEST_LOCATION_UPDATE);
        return !(spinnerAccept.indexOf(urls)>=0);
    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


    private void errorToast() {
        mCurrentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mCurrentActivity, "네트워크 오류가 있습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onFileChooseFinish(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == BasicVariables.HTTP_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(mCurrentActivity.getApplicationContext().getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void startSendData(final Map<String, String> jsonDatas, String dataRequestURL) {
        multipartVolley(bitmap, jsonDatas, dataRequestURL);
    }



}
