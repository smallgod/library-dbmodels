 package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum CampaignStatus implements Constants {

    DRAFT("DRAFT"), //ad still in draft form, not yet placed //STEP-0
    NEW("NEW"), //An ad just placed  //STEP-1 - temporarily create schedule for ad pending payment - expire reservation after a couple minutes
    PENDING_PAYMENT("PENDING PAYMENT"), //STEP-2 - ad picked for payment
    //SCHEDULING("SCHEDULING"), //STEP-3 - After Ad is paid, make schedule permanent
    IN_REVIEW("IN REVIEW"), //STEP-4 //should include optimising
    ACTIVE("ACTIVE"), //when scheduled OR afer review & just waiting to be scheduled //STEP-5
    COMPLETED("COMPLETED"), //Reached it's display end_date //STEP-6
    FLAGGED("FLAGGED"), //Can be at any STEP - when ad is flagged off by system or admin for possible violation of Terms of Uses
    ESCALATED("ESCALATED"), //Can be at any STEP - When one of the steps is problematic especially payments
    REJECTED("REJECTED"),//Can be at any STEP
    REVERSED("REVERSED");//Can be at any STEP

    /*
     LOG(1),
    AUTHORISE(2),
    PAY(3),
    OPTIMISE(4),
    SCHEDULE(5),
    DISPLAY(5),
    FINAL(6); //successful or customer refunded
     */
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
