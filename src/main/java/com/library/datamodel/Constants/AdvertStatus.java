package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 * 
 * @author smallgod
 */
public enum AdvertStatus implements Constants {

    PROCESSING("PROCESSING"),
    SUCCESSFUL("SUCCESSFUL"),
    REJECTED("REJECTED"),
    REVERSED("REVERSED");
    
    private final String adStatus;

    private static final LoggerUtil logger = new LoggerUtil(AdvertStatus.class);

    AdvertStatus(String adStatus) {
        this.adStatus = adStatus;
    }

    @Override
    public String getValue() {
        return this.adStatus;
    }

    public static AdvertStatus convertToEnum(String adStatusValue) {

        if (adStatusValue != null) {

            for (AdvertStatus adStatusEnum : AdvertStatus.values()) {

                if (adStatusValue.equalsIgnoreCase(adStatusEnum.getValue())) {
                    return adStatusEnum;
                }
            }
        }
        logger.warn("No constant with text " + adStatusValue + " found");
        throw new IllegalArgumentException("No constant with text " + adStatusValue + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + adStatusValue, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
