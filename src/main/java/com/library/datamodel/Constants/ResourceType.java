package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.sglogger.util.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum ResourceType implements Constants {

    IMAGE(0),
    VIDEO(1),
    AUDIO(2),
    FLASH(3),
    TEXT(4);

    private final int enumValue;

    private static final LoggerUtil logger = new LoggerUtil(ResourceType.class);

    ResourceType(int enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public Integer getValue() {
        return this.enumValue;
    }

    public static ResourceType convertToEnum(int value) {

        if (!(((value + "").trim()).isEmpty())) {

            for (ResourceType availableValue : ResourceType.values()) {

                if (value == availableValue.getValue()) {
                    return availableValue;
                }
            }
        }
        logger.warn("No constant with text " + value + " found");
        throw new IllegalArgumentException("No constant with text " + value + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + value, ErrorCategory.CLIENT_ERR_TYPE);
    }
}