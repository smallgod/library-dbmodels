package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.sglogger.util.LoggerUtil;

/**
 * Represents the different states a processing unit such as a monitoring unit or AdDisplay unit 
 * could be in at any one moment
 * @author smallgod
 */
public enum ProcessingUnitState implements Constants {

    BUSY("BUSY"), //Already processing
    HONOURED("HONOURED"),//Ready to process/respond to call
    RETRY("RETRY"),//A unit might not have any resources to handle this request
    ERROR("ERROR"),//If a unit throws an error, this needs to be reported/logged, CS determines what to do next
    POLL("POLL"); //Polling for any Pending ads
    
    private final String unitStateString;

    private static final LoggerUtil logger = new LoggerUtil(ProcessingUnitState.class);

    ProcessingUnitState(String unitStateString) {
        this.unitStateString = unitStateString;
    }

    @Override
    public String getValue() {
        return this.unitStateString;
    }

    public static ProcessingUnitState convertToEnum(String unitState) {

        if (unitState != null) {

            for (ProcessingUnitState procUnitState : ProcessingUnitState.values()) {

                if (unitState.equalsIgnoreCase(procUnitState.getValue())) {
                    return procUnitState;
                }
            }
        }
        logger.warn("No constant with text " + unitState + " found");
        throw new IllegalArgumentException("No constant with text " + unitState + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + unitState, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
