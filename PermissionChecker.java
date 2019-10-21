package com.MyUtilities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PermissionChecker {
    private static final PermissionChecker ourInstance = new PermissionChecker();

    public static PermissionChecker getInstance() {
        return ourInstance;
    }

    private Activity mActivity;
    private int REQUEST_PERMISSION_CODE = 8808;
    private ArrayList<String> permissionList = new ArrayList<>();

    private PermissionChecker() {
    }

    public PermissionChecker init(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public PermissionChecker addPermission(String permitList) {
        this.permissionList.add(permitList);
        return this;
    }



    public PermissionChecker checkPermissions() {
        String[] permitArray = new String[permissionList.size()];
        int idx = 0;

        for (String permitStr: permissionList) {
            permitArray[idx] = permitStr;
            idx++;
        }

        if (!checkPermission()) {
            ActivityCompat.requestPermissions(mActivity, permitArray,
                    REQUEST_PERMISSION_CODE);
        }
        return null;
    }

    private Boolean checkPermission() {
        int i=0;
        boolean permissionResult = true;
        do {

            if (ContextCompat.checkSelfPermission(this.mActivity, permissionList.get(i) ) != PackageManager.PERMISSION_GRANTED) {
                permissionResult = false;
                break;
            }
            i++;
        }while (i < (permissionList.size()) );
        return permissionResult;
    }


}
