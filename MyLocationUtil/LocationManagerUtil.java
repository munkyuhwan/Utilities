package com.MyUtilities.MyLocationUtil;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

import com.MyUtilities.MyHttpRequest.Interfaces.MainInterface;
import com.dokdo.R;

public class LocationManagerUtil {
    private static final LocationManagerUtil ourInstance = new LocationManagerUtil();

    public static LocationManagerUtil getInstance() {
        return ourInstance;
    }

    private LocationManagerUtil() {
    }

    private MainInterface mainInterface;
    public LocationManagerUtil init(final Activity activity, MainInterface mainInterface) {
        this.mainInterface = mainInterface;
        if (!isLocationEnabled(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, activity.getString(R.string.gps_enable), Toast.LENGTH_SHORT).show();
                }
            });
            activity.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
        return this;
    }

    private LocationManager manager = null;
    private LocationListenerUtil locationListenerUtil = null;
    public LocationManagerUtil getLocationData(Activity activity) {
        Log.e("tag","'''''''start request location===========================");
        this.locationListenerUtil = new LocationListenerUtil(activity, this.mainInterface);
        if (activity.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && activity.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }else {
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListenerUtil);
        }
        return this;
    }

    private boolean isLocationEnabled(Activity activity) {
        manager = (LocationManager) activity.getSystemService( Context.LOCATION_SERVICE );
        return (manager.isProviderEnabled( LocationManager.GPS_PROVIDER)||manager.isProviderEnabled( LocationManager.NETWORK_PROVIDER));
    }

    public void dismissLocationUpdate() {
        Log.e("tag","'''''''remove listener===========================");
        if (manager != null) {
            manager.removeUpdates(locationListenerUtil);
            manager = null;
        }
    }

    public LocationManager getManager() {
        return manager;
    }

    public void setManager(LocationManager manager) {
        this.manager = manager;
    }

}
