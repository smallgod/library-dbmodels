package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum CampaignStatus implements Constants {

    DRAFT("DRAFT"),
    PENDING_PAYMENT("PENDING_PAYMENT"),
    IN_REVIEW("IN_REVIEW"),
    ACTIVE("ACTIVE"), //when scheduled
    COMPLETED("COMPLETED"), //when reached end_date
    FLAGGED("FLAGGED"),
    REJECTED("REJECTED"),
    REVERSED("REVERSED");

    private final String enumValue;

    CampaignStatus(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static CampaignStatus convertToEnum(String value) throws MyCustomException {

        if (value != null) {

            for (CampaignStatus availableValue : CampaignStatus.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Advert Campaign Status", "Failed to convert Advert Campaign Status: " + value + "to Enum");
        throw error;
    }
}
