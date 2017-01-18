package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum ResourceType implements Constants {

    HEADER_TEXT("HEADER_TEXT"),
    SCROLL_TEXT("SCROLL_TEXT"),
    VIDEO("VIDEO"),
    IMAGE("IMAGE");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(ResourceType.class);

    ResourceType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ResourceType convertToEnum(String value) {

        if (value != null) {

            for (ResourceType availableValue : ResourceType.values()) {

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
