package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;
/**
 * 
 * @author smallgod
 */
public enum APIMethodName implements Constants {

    WAKEUP_REQUEST("WAKEUP_REQUEST"),
    SCHEDULE_REQUEST("SCHEDULE_REQUEST"),
    FETCH_REQUEST("ADFETCH_REQUEST"),
    PLAYER_DETAIL("PLAYER_DETAIL"),
    GENERATE_ID("GENERATE_ID"),
    DSM_AD_SCHEDULE("DSM_AD_SCHEDULE"), 
    ADVERT_SETUP("ADVERT_SETUP");
    
    private final String methodNameString;

    private static final LoggerUtil logger = new LoggerUtil(APIMethodName.class);

    APIMethodName(String wrapperNodeStr) {
        this.methodNameString = wrapperNodeStr;
    }

    @Override
    public String getValue() {
        return this.methodNameString;
    }

    public static APIMethodName convertToEnum(String methodName) {

        if (methodName != null) {

            for (APIMethodName availableMethodName : APIMethodName.values()) {

                if (methodName.equalsIgnoreCase(availableMethodName.getValue())) {
                    return availableMethodName;
                }
            }
        }
        logger.warn("No constant with text " + methodName + " found");
        throw new IllegalArgumentException("No constant with text " + methodName + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + methodName, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
