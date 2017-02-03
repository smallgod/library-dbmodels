package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum ValueStore implements Constants {

    MTNMOMO_UG("MTNMOMO_UG"),
    AIRTELMOMO_UG("AIRTELMOMO_UG"),
    CENTE_UG("CENTE_UG"),
    CELLUMONEY("CELLUMONEY"),
    CASHMONEY("CASHMONEY"),
    STANBIC_UG("STANBIC_UG"),
    UNKNOWNSTORE("UKNOWNSTORE");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(ValueStore.class);

    ValueStore(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ValueStore convertToEnum(String value) {

        if (value != null) {

            for (ValueStore availableValue : ValueStore.values()) {

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
