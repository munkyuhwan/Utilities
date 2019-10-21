package com.MyUtilities.MyLocationUtil;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.MyUtilities.MyHttpRequest.Interfaces.MainInterface;

public class LocationListenerUtil implements LocationListener {

    private Activity mActivity;
    private MainInterface mainInterface;
    public LocationListenerUtil(Activity activity, MainInterface mainInterface) {
        this.mActivity = activity;
        this.mainInterface = mainInterface;
    }

    @Override
    public void onLocationChanged(Location location) {
        //LocationUpdateRequest updateLocation = new LocationUpdateRequest(this.mActivity);
        //updateLocation.updateLocation(location, this.mainInterface);

        LocationUpdateRequestSingleton.getInstance().updateLocation(this.mActivity, location, this.mainInterface);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
