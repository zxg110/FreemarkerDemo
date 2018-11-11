package com.for_future.codegenerator;

public class AppUrl {
    public static final String BASE_URL_RELEASE = "https://api.saicmobility.com";//"http://api-uat.saicmobility.com:10080";//"http://api-test.saicmobility.com:10080";
    public static final String MQTT_URL_RELEASE = "ssl://mqtt.saicmobility.com:8883";
    public static final String DRIVER_ACTIVATE_URL = "/auth/v2/driveractivate";
    public static final String LOGIN_URL = "/auth/v2/login/driver/mobile";
    public static final String COMMON_RESOURCE_URL = "/driver/v2/cms/conf";
    public static final String MODE_STATUS_URL = "/driver/v2/work/%s/update";
    public static final String DELETE_EMERGENCY_CONTACT_URL = "/driver/v2/emergencycontact/delete/%s";
    public static final String UPLOAD_FILE_URL = "/driver/v2/auth/uploadfile";
}
