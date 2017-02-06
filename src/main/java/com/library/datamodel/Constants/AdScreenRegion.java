package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 *
 * The screen needs to be sub-divided into any of the following known
 * sub-regions
 */
public enum AdScreenRegion implements Constants {

    CENTER("CENTER"),
    RIGHT("RIGHT"),
    LEFT("LEFT"),
    LOWER_RIGHT("LOWER_RIGHT"),
    LOWER_LEFT("LOWER_LEFT");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(AdScreenRegion.class);

    AdScreenRegion(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static AdScreenRegion convertToEnum(String value) {

        if (value != null) {

            for (AdScreenRegion availableValue : AdScreenRegion.values()) {

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
