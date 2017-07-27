package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum TransactionAggregatorStatus implements Constants {

    NOT_LOGGED("NOT_LOGGED"), //Payment NOT logged to DB for some reason other than 'duplicate', etc
    LOGGED("LOGGED"), //Payment logged to the DB
    PROCESSING("PROCESSING"), //Payment fetched for processing
    SUCCESSFUL("SUCCESSFUL"),
    FAILED("FAILED"),
    REVERSED("REVERSED"),
    DUPLICATE("DUPLICATE"),
    EXPIRED("EXPIRED"),
    UNKNOWN("UNKNOWN"),
    ALL("ALL"); //used when we need to pick multiple payments with status n- any

    private final String enumValue;

    TransactionAggregatorStatus(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static TransactionAggregatorStatus convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (TransactionAggregatorStatus availableValue : TransactionAggregatorStatus.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Advert Campaign Status", "Failed to convert Advert Campaign Status: " + value + "to Enum");
        throw error;
    }
}
