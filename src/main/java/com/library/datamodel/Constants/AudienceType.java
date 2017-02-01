package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum AudienceType implements Constants {

    MEN("MEN"),
    WOMEN("WOMEN"),
    KIDS("KIDS"),
    MEN_WOMEN("MEN_WOMEN"),
    CORPORATES("CORPORATES"),
    ALL("ALL"),
    BODARIDERS("BODARIDERS");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(AudienceType.class);

    AudienceType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static AudienceType convertToEnum(String value) {

        if (value != null) {

            for (AudienceType availableValue : AudienceType.values()) {

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
