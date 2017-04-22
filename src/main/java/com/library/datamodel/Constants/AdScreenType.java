package com.library.datamodel.Constants;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Constants;
import com.library.sglogger.util.LoggerUtil;

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

    public static AdScreenType convertToEnum(String value) {

        if (value != null) {

            for (AdScreenType availableValue : AdScreenType.values()) {

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
