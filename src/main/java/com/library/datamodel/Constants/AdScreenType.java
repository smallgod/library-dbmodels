package com.library.datamodel.Constants;

import com.google.gson.annotations.SerializedName;
import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.sglogger.util.LoggerUtil;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum AdScreenType implements Constants {

    @SerializedName("KABUTO_TV")
    KABUTO_TV("KABUTO_TV"),
    @SerializedName("FLAT_LCD_TV")
    FLAT_LCD_TV("FLAT_LCD_TV"),
    @SerializedName("FLAT_LED_TV")
    FLAT_LED_TV("FLAT_LED_TV"),
    @SerializedName("KABUTO_MONITOR")
    KABUTO_MONITOR("KABUTO_MONITOR"),
    @SerializedName("FLAT_LCD_MONITOR")
    FLAT_LCD_MONITOR("FLAT_LCD_MONITOR");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(AdScreenType.class);

    AdScreenType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static AdScreenType convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (AdScreenType availableValue : AdScreenType.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported screen type value", "Failed to convert value: " + value + " to Enum");
        throw error;

    }
}
