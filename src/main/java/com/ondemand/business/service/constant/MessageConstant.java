package com.ondemand.business.service.constant;

public class MessageConstant {

   public static final String CATEGORY_REQUIRED="Category Required";

   public static final String CATEGORY_DETAILS="Category Details";
   public  static final String ALL_CATEGORY_DETAILS="All Category List...!";

    public static interface Agency{
        public static String ERROR_AGENCY_LICENCE_NUMBER_MIN_LENGTH="Enter Minimum "+ Constant.Length.AGENCY_LICENCE_MIN_NUMBER+" digit Licence Number";
        public static String ERROR_AGENCY__LICENCE_MAX_LENGTH_NUMBER="Enter Maximum "+Constant.Length.AGENCY_LICENCE_MAX_NUMBER+" digit Licence Number";
        public static String ERROR_AADHAR_NUMBER="Enter Aadhar Number";
        public static String ERROR_AADHAR_NUMBER_LENGTH="Enter Valid "+Constant.Length.AGENCY_AADHAR_NUMBER_LENGTH+" Aadhar Number";
        public static String ERROR_AGENCY_CITY="Enter Agency City Required";
        public static String ERROR_AGENCY_StATE="Enter Agency State Required";
        public static String ERROR_AGENCY_COUNTRY="Enter Agency Country Required";
        public static String ERROR_AGENCY_NAME="Enter Agency Name";
        public static String ERROR_AGENCY_NAME_MIN_LENGTH="Enter Minimum "+Constant.Length.AGENCY_NAME_MIN_LENGTH+" Character Agency Name";
        public static String ERROR_AGENCY_NAME_MAX_LENGTH="Enter Maximum "+Constant.Length.AGENCY_NAME_MAX_LENGTH+" Character Agency Name";
        public static String ERROR_AGENCY_MOBILE_NUMBER="Enter Mobile Number";
        public static String ERROR_AGENCY_VALID_MOBILE_NUMBER_LENGTH="Enter Valid "+Constant.Length.MOBILE_NUMBER_LENGTH+" Digit Mobile Number";

        public static String SUCCESS_AGENCY_CREATE_SUCCESSFULLY="Agency Create Successfully...!";
        public static String ERROR_AGENCY_ALREADY_REGISTER="Agency Already Register";

        public static String SUCCESS_AGENCY_SERVICE_ADDED="Agency Service Added...";

        public static String AGENCY_DETAILS_FETCHED="Agency Details Fetched Successfully...!";

    }

    public static interface Error{
        public static String AGENCY_NOT_FOUND="Agency Licence Number does not exist";
        public static String CATEGORY_NOT_FOUND="Category not found...!";
    }
}
