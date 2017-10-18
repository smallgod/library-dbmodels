package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum ScreenSplit implements Constants {

    TWO_SPLIT("2SPLIT"),
    THREE_SPLIT("3SPLIT"),
    TEXT_ONLY("TEXT"),
    FULL_SCREEN("FULLSCREEN"),
    FULLSCREEN_TEXT("FULLSCREEN_TEXT"),
    AV_ONLY("AV_ONLY"),
    UNKNOWN("UNKNOWN");

    private final String enumValue;

    ScreenSplit(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ScreenSplit convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (ScreenSplit availableValue : ScreenSplit.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported screen split layout", "Failed to convert split layout Name: " + value + "to Enum");
        throw error;
    }
}
