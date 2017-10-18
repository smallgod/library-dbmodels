package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum AdPaymentStatus implements Constants {

    PAY_DRAFT("DRAFT"), //for just saved campaigns - still in draft form
    PAY_NEW("NEW"), //Newly logged payment
    PAY_INITIATED("INITIATED"),
    PAID("PAID"),
    PAY_FAILED("FAILED"),
    PAY_REVERSED("REVERSED"),
    //PAY_EXPIRED("EXPIRED"), //time for payment has expired
    STATUS_UNKNOWN("UNKNOWN");

    private final String payStatus;

    AdPaymentStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String getValue() {
        return this.payStatus;
    }

    /**
     *
     * @param payStatusValue
     * @return
     * @throws MyCustomException
     */
    public static AdPaymentStatus convertToEnum(String payStatusValue) throws MyCustomException {

        if (payStatusValue != null) {

            for (AdPaymentStatus payStatusEnum : AdPaymentStatus.values()) {

                if (payStatusValue.equalsIgnoreCase(payStatusEnum.getValue())) {
                    return payStatusEnum;
                }
            }
        }
        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Payment status", "Failed to convert payment status: " + payStatusValue + "to Enum");
        throw error;
    }
}
