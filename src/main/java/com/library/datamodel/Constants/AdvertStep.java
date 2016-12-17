package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum AdvertStep implements Constants {

    //we also have advert status
    //PROCESSING | REJECTED | SUCCESSFUL | REVERSED
    LOG(1),
    AUTHORISE(2),
    PAY(3),
    OPTIMISE(4),
    SCHEDULE(5),
    DISPLAY(5),
    FINAL(6); //successful or customer refunded

    private final int adStep;

    private static final LoggerUtil logger = new LoggerUtil(AdvertStep.class);

    AdvertStep(int adStep) {
        this.adStep = adStep;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.adStep);
    }

    public static AdvertStep convertToEnum(int adStepValue) {

        if (adStepValue >= 1) {

            for (AdvertStep adStepEnum : AdvertStep.values()) {

                if (adStepValue == Integer.parseInt(adStepEnum.getValue())) {
                    return adStepEnum;
                }
            }
        }
        logger.warn("No constant with text " + adStepValue + " found");
        throw new IllegalArgumentException("No constant with text " + adStepValue + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + adStepValue, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
