package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum ProgDisplayLayout implements Constants {

    TWO_SPLIT("2SPLIT"),
    
    THREE_SPLIT("3SPLIT"),
    TEXT_ONLY("TEXT"),
    FULL_SCREEN("FULLSCREEN"),
    FULLSCREEN_TEXT("FULLSCREEN_TEXT"),
    AV_ONLY("AV_ONLY");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(ProgDisplayLayout.class);

    ProgDisplayLayout(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ProgDisplayLayout convertToEnum(String value) {

        if (value != null) {

            for (ProgDisplayLayout availableValue : ProgDisplayLayout.values()) {

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
