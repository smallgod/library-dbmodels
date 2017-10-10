package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum AccountType implements Constants {

    PREPAID("PREPAID"),
    POSTPAID("POSTPAID");

    private final String enumValue;

    AccountType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static AccountType convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (AccountType availableValue : AccountType.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Account type", "Failed to convert account type: " + value + "to Enum");
        throw error;
    }
}
