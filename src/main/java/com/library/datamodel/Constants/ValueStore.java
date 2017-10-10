package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum ValueStore implements Constants {

    SEYEYA_CREDIT("SEYEYA_CREDIT"),
    MTNMOMO_UG("MTNMOMO_UG"),
    AIRTELMOMO_UG("AIRTELMOMO_UG"),
    CENTE_UG("CENTE_UG"),
    CELLUMONEY("CELLUMONEY"),
    CASHMONEY("CASHMONEY"),
    STANBIC_UG("STANBIC_UG"),
    GTBANK_UG("GTBANK_UG"),
    UNKNOWNSTORE("UKNOWNSTORE");

    private final String enumValue;

    ValueStore(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ValueStore convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (ValueStore availableValue : ValueStore.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Advert Campaign Status", "Failed to convert Advert Campaign Status: " + value + "to Enum");
        throw error;
    }
}
