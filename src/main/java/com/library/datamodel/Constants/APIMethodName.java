package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum APIMethodName implements Constants {

    AUTHENTICATE_USER("AUTHENTICATE_USER"),
    CREATE_ACCOUNT("CREATE_ACCOUNT"),
    GET_PRICE("GET_PRICE"),
    GET_AREAS("GET_AREAS"),
    GET_BUSINESS_TYPES("GET_BUSINESS_TYPES"),
    GET_AUDIENCE_TYPES("GET_AUDIENCE_TYPES"),
    GET_TIMESLOTS("GET_TIMESLOTS"),
    PLACE_AD("PLACE_AD"),
    GET_USER_ADVERTS("GET_USER_ADVERTS"),
    WAKEUP_REQUEST("WAKEUP_REQUEST"),
    SCHEDULE_REQUEST("SCHEDULE_REQUEST"),
    FETCH_REQUEST("ADFETCH_REQUEST"),
    PLAYER_DETAIL("PLAYER_DETAIL"),
    GENERATE_ID("GENERATE_ID"),
    DAILY_SETUP_STEP1("DAILY_SETUP_STEP1"),
    DAILY_SETUP_STEP2("DAILY_SETUP_STEP2"),
    DSM_AD_SCHEDULE("DSM_AD_SCHEDULE"),
    BULK_ADVERT_SETUP("BULK_ADVERT_SETUP"),
    FETCH_ENTITY("FETCH_ENTITY"),
    FETCH_BULK("FETCH_BULK"),
    UPDATE_BULK("UPDATE_BULK"),
    BIND_TERMINALS("BIND_TERMINALS"),
    SAVE_BULK("SAVE_BULK"),
    FETCH_RESOURCES("FETCH_RESOURCES");

    private final String methodNameString;

    APIMethodName(String wrapperNodeStr) {
        this.methodNameString = wrapperNodeStr;
    }

    @Override
    public String getValue() {
        return this.methodNameString;
    }

    public static APIMethodName convertToEnum(String methodName) throws MyCustomException {

        if (methodName != null) {

            for (APIMethodName availableMethodName : APIMethodName.values()) {

                if (methodName.equalsIgnoreCase(availableMethodName.getValue())) {
                    return availableMethodName;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported API Method Name", "Failed to convert API Method Name: " + methodName + "to Enum");

        throw error;

    }
}
