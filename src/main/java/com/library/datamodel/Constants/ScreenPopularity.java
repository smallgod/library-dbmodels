package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum ScreenPopularity implements Constants {

    LEAST_POPULAR("hardly watched"),
    AVERAGE("average"),
    MOST_POPULAR("most watched");

    private final String enumValue;

    ScreenPopularity(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static ScreenPopularity convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (ScreenPopularity availableValue : ScreenPopularity.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported popularity value", "Failed to convert value: " + value + " to Enum");
        throw error;
    }
}
