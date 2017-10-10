package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum LocationType implements Constants {

    ADVERT_LOCATION("ADVERT_LOCATION"),
    CLIENT_LOCATION("CLIENT_LOCATION"),
    ANY("ANY");

    private final String strValue;

    LocationType(String strValue) {
        this.strValue = strValue;
    }

    @Override
    public String getValue() {
        return this.strValue;
    }

    public static LocationType convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (LocationType enumValue : LocationType.values()) {

                if (value.equalsIgnoreCase(enumValue.getValue())) {
                    return enumValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported location type", "Failed to convert location type: " + value + " to Enum");
        throw error;
    }
}
