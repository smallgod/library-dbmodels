package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum AdLength implements Constants {

    SIXTY_SEC(60), //the price of an advert is relative to its length, so multiply ad price by this multiplier e.g. 1.3f
    THIRTY_SEC(30);

    private final int enumValue;

    AdLength(int enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.enumValue);
    }

    public static AdLength convertToEnum(int value) throws MyCustomException {

        if (value > 0) {

            for (AdLength availableValue : AdLength.values()) {

                if (value == Integer.parseInt(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Advert length", "Failed to convert Advert Length: " + value + "to Enum");
        throw error;
    }
}
