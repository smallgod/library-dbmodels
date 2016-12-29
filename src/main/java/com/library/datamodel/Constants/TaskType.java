package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum TaskType implements Constants {

    LOOP("loop"),
    DEMAND("demand"),
    PLUGIN("plugin");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(TaskType.class);

    TaskType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static TaskType convertToEnum(String value) {

        if (value != null) {

            for (TaskType availableValue : TaskType.values()) {

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
