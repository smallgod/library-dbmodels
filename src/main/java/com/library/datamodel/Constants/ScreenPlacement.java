package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum ScreenPlacement implements Constants {

    HOTEL_ROOM("hotel room"),
    LOUNGE("lounge"),
    MAIN_ENTRANCE("main entrance"),
    MAIN_RECEPTION("main reception"),
    RECEPTION("reception"),
    DORM_ROOM("dorm room"),
    WATCHING_AREA("watching area"),
    DINING_AREA("dining area"),
    COMMON_ROOM("common room"),
    UNKNOWN("UNKNOWN");

    private final String enumValue;

    ScreenPlacement(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ScreenPlacement convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (ScreenPlacement availableValue : ScreenPlacement.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported placement", "Failed to convert split placement Name: " + value + "to Enum");
        throw error;
    }
}
