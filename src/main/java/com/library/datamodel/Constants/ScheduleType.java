package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum ScheduleType implements Constants {

    INSTANT("INSTANT"),
    LATER("LATER");

    private final String enumValue;

    ScheduleType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ScheduleType convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (ScheduleType availableValue : ScheduleType.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Schedule type", "Failed to convert schedule type: " + value + "to Enum");
        throw error;
    }
}
