package com.library.datamodel.Constants;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Constants;
import com.library.sglogger.util.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum AdScreenSize implements Constants {

    @SerializedName("15 INCH")
    FIFTEEN("15 INCH"),
    
    @SerializedName("21 INCH")
    TWENTYONE("21 INCH"),
    
    @SerializedName("29 INCH")
    TWENTYNINE("29 INCH"),
    
    @SerializedName("32 INCH")
    THIRTYTWO("32 INCH"),
    
    @SerializedName("40 INCH")
    FOURTY("40 INCH"),
    
    @SerializedName("52 INCH")
    FIFTYTWO("52 INCH");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(AdScreenSize.class);

    AdScreenSize(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static AdScreenSize convertToEnum(String value) {

        if (value != null) {

            for (AdScreenSize availableValue : AdScreenSize.values()) {

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
