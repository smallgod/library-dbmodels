package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum UserType implements Constants {

    CLIENT("CLIENT"),
    SCREEN_OWNER("SCREEN_OWNER");

    private final String enumValue;

    UserType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static UserType convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (UserType availableValue : UserType.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported User Type", "Failed to convert User type: " + value + "to Enum");
        throw error;
    }
}
