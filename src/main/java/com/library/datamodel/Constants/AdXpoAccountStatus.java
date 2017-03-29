package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum AdXpoAccountStatus implements Constants {

    ACTIVE("ACTIVE"),
    SUSPENDED("SUSPENDED"),
    PENDING_OTP("PENDING_OTP"),
    FLAGGED("FLAGGED"),
    DELETED("DELETED"),
    EXPIRED("EXPIRED"),
    GUEST("GUEST"); //user who is not yet registered aka Guest User

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(AdXpoAccountStatus.class);

    AdXpoAccountStatus(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static AdXpoAccountStatus convertToEnum(String value) {

        if (value != null) {

            for (AdXpoAccountStatus availableValue : AdXpoAccountStatus.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        logger.warn("No constant with text " + value + " found");
        throw new IllegalArgumentException("No constant with text " + value + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + value, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
