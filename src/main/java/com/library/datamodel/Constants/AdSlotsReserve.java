package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 * Whether or not the given reserved advertising slots for a campaign are fixed
 * or temporary. This depends on conditions such as; is Payment done? is
 * Campaign reviewed? etc
 *
 * @author smallgod
 */
public enum AdSlotsReserve implements Constants {

    FREE("FREE"), //not yet booked
    TEMPORAL("TEMPORAL"), //temporarily booked
    FIXED("FIXED"); //permanently booked

    private final String enumValue;

    AdSlotsReserve(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static AdSlotsReserve convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (AdSlotsReserve availableValue : AdSlotsReserve.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported AdSlotReserve", "Failed to convert value: " + value + "to Enum");
        throw error;
    }
}
