package com.ondemand.business.service.constant;

public class Constant {
    public static String ROLE_USER = "USER";




    public static interface Status {
        public static String ERROR = "error";
        public static String SUCCESS = "Success";

    }

    public static interface Length {
        public static int AGENCY_NAME_MIN_LENGTH = 5;
        public static int AGENCY_NAME_MAX_LENGTH = 20;
        public static int AGENCY_LICENCE_MIN_NUMBER = 10;
        public static int AGENCY_LICENCE_MAX_NUMBER = 15;
        public static int AGENCY_AADHAR_NUMBER_LENGTH = 12;
        public static int MOBILE_NUMBER_LENGTH = 10;

    }
}
