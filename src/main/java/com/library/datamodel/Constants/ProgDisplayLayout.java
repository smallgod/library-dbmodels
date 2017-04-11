package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

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
    AV_ONLY("AV_ONLY"),
    UNKNOWN("UNKNOWN");

    private final String enumValue;

    ProgDisplayLayout(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ProgDisplayLayout convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (ProgDisplayLayout availableValue : ProgDisplayLayout.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Display layout", "Failed to convert layout Name: " + value + "to Enum");
        throw error;
    }
}
