package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum AdPaymentStatus implements Constants {

    NOT_PAID("NOT_PAID"),
    INITIATED("PAY_REQUESTED"),
    PAID("PAID"),
    REVERSED("REVERSED");

    private final String payStatus;

    private static final LoggerUtil logger = new LoggerUtil(AdPaymentStatus.class);

    AdPaymentStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String getValue() {
        return this.payStatus;
    }

    public static AdPaymentStatus convertToEnum(String payStatusValue) {

        if (payStatusValue != null) {

            for (AdPaymentStatus payStatusEnum : AdPaymentStatus.values()) {

                if (payStatusValue.equalsIgnoreCase(payStatusEnum.getValue())) {
                    return payStatusEnum;
                }
            }
        }
        logger.warn("No constant with text " + payStatusValue + " found");
        throw new IllegalArgumentException("No constant with text " + payStatusValue + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + payStatusValue, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
