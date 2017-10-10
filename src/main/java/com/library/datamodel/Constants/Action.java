package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum Action implements Constants {

    CREATE("CREATE"),
    UPDATE("UPDATE");

    private final String enumValue;

    Action(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static Action convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (Action availableValue : Action.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported action", "Failed to convert value: " + value + " to Enum");
        throw error;
    }
}
