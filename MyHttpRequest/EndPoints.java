package com.MyUtilities.MyHttpRequest;

public class EndPoints {
    private static final String ROOT_URL = "http://192.168.219.106:8080/api/v1/";
    public static final String UPLOAD_URL = ROOT_URL + "uploadpic/";
    public static final String UPLOAD_data_URL = ROOT_URL + "upload_data/";
    public static final String GET_PICS_URL = ROOT_URL + "getpics/";

    public static final String GET_LIST_URL = ROOT_URL +"order_list/";

    public static final String UPDATE_STATUS = ROOT_URL +"update_status/";
    public static final String LOGIN_CHECK = ROOT_URL +"check_login/";
    public static final String SELECT_LOGIN = ROOT_URL +"select_login/";
    public static final String CHECK_LOGIN_URL = ROOT_URL +"check_login/";

    public static final String GET_BULLETIN_LIST = ROOT_URL+"get_bulletin/";
    public static final String GET_SAFETY_LIST = ROOT_URL+"get_safety/";
    public static final String REQUEST_LOCATION_UPDATE = ROOT_URL+"update_location/";

    public static final String CHECK_STATUS = ROOT_URL+"check_status/";

    public static final String GET_MYACCOUNT = ROOT_URL+"my_account/";




    public static final String BULLETIN_LIST_TAG = "bulletin_list";
    public static final String SAFETY_LIST_TAG = "safety_list";
    public static final String ORDER_LIST_TAG = "order_list";
    public static final String UPDATE_LOCATION_TAG = "update_location";
    public static final String CHECK_STATUS_TAG = "check_status";
    public static final String GET_MYACCOUNT_TAG = "my_account";
}