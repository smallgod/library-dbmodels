package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum TimeSlot implements Constants {

    INSTANT("INSTANT"),
    EARLY_BIRD("EARLY_BIRD"),
    LUNCH_HOUR("LUNCH_HOUR"),
    RUSH_HOUR("RUSH_HOUR"),
    PRIME_TIME("PRIME_TIME");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(TimeSlot.class);

    TimeSlot(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static TimeSlot convertToEnum(String value) {

        if (value != null) {

            for (TimeSlot availableValue : TimeSlot.values()) {

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
