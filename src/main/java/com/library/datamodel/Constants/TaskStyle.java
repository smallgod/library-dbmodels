package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.sglogger.util.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum TaskStyle implements Constants {

    BREAK("break"),
    CONTINUE("continue");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(TaskStyle.class);

    TaskStyle(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static TaskStyle convertToEnum(String value) {

        if (value != null) {

            for (TaskStyle availableValue : TaskStyle.values()) {

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
