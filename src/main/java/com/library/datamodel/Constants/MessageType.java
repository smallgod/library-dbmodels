package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum MessageType implements Constants {

    ASSIGN_ID_CHANGE("ASSIGN_ID_CHANGE"),
    LOOP_TASK_CHANGE("LOOP_TASK_CHANGE");

    private final String enumValue;

    MessageType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static MessageType convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (MessageType availableValue : MessageType.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Message type", "Failed to convert message type: " + value + "to Enum");
        throw error;
    }
}
