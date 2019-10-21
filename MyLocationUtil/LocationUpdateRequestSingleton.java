package com.MyUtilities.MyLocationUtil;

import android.app.Activity;
import android.location.Location;

import com.MyUtilities.MyHttpRequest.EndPoints;
import com.MyUtilities.MyHttpRequest.Interfaces.MainInterface;
import com.MyUtilities.MyHttpRequest.VolleyRequestSingleton;

import java.util.HashMap;
import java.util.Map;

public class LocationUpdateRequestSingleton {
    private static final LocationUpdateRequestSingleton ourInstance = new LocationUpdateRequestSingleton();

    public static LocationUpdateRequestSingleton getInstance() {
        return ourInstance;
    }

    private LocationUpdateRequestSingleton() {
    }
    public void updateLocation(Activity activity, Location location, MainInterface mainInterface) {
        Map<String, String> data = new HashMap<>();
        data.put("tag", EndPoints.UPDATE_LOCATION_TAG);
        data.put("latitude", String.valueOf(location.getLatitude()) );
        data.put("longitude", String.valueOf(location.getLongitude()) );
        VolleyRequestSingleton.getInstance().initVolley(activity, mainInterface);
        VolleyRequestSingleton.getInstance().startSendData(data, EndPoints.REQUEST_LOCATION_UPDATE);
    }

}
