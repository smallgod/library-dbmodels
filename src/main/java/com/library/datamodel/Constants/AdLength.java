package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum AdLength implements Constants {

    SIXTY_SEC(60), //the price of an advert is relative to its length, so multiply ad price by this multiplier e.g. 1.3f
    THIRTY_SEC(30);

    private final int enumValue;

    private static final LoggerUtil logger = new LoggerUtil(AdLength.class);

    AdLength(int enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.enumValue);
    }

    public static AdLength convertToEnum(int value) {

        if (value > 0) {

            for (AdLength availableValue : AdLength.values()) {

                if (value == Integer.parseInt(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        logger.warn("No constant with text " + value + " found");
        throw new IllegalArgumentException("No constant with text " + value + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + value, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
