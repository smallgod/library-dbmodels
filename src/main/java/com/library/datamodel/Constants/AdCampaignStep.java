package com.library.datamodel.Constants;

import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum AdCampaignStep implements Constants {

    DRAFT("DRAFT"),
    PENDING_PAYMENT("PENDING_PAYMENT"),
    IN_REVIEW("IN_REVIEW"),
    ACTIVE("ACTIVE"), //when scheduled
    COMPLETED("COMPLETED"), //when reached end_date
    FLAGGED("FLAGGED"),
    REJECTED("REJECTED"),
    REVERSED("REVERSED");

    private final String enumValue;

    private static final LoggerUtil logger = new LoggerUtil(AdCampaignStep.class);

    AdCampaignStep(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public String getValue() {
        return this.enumValue;
    }

    public static AdCampaignStep convertToEnum(String value) {

        if (value != null) {

            for (AdCampaignStep availableValue : AdCampaignStep.values()) {

                if (value.equalsIgnoreCase(availableValue.getValue())) {
                    return availableValue;
                }
            }
        }
        logger.warn("No constant with text " + value + " found");
        throw new IllegalArgumentException("No constant with text " + value + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + value, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
