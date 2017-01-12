package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 * 
 * @author smallgod
 */
public enum GenerateId implements Constants {

    FILE_ID("FILE_ID"),
    TASK_ID("TASK_ID");
    
    private final String generateId;

    private static final LoggerUtil logger = new LoggerUtil(GenerateId.class);

    GenerateId(String generateId) {
        this.generateId = generateId;
    }

    @Override
    public String getValue() {
        return this.generateId;
    }

    public static GenerateId convertToEnum(String generateIdValue) {

        if (generateIdValue != null) {

            for (GenerateId adStatusEnum : GenerateId.values()) {

                if (generateIdValue.equalsIgnoreCase(adStatusEnum.getValue())) {
                    return adStatusEnum;
                }
            }
        }
        logger.warn("No constant with text " + generateIdValue + " found");
        throw new IllegalArgumentException("No constant with text " + generateIdValue + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + generateIdValue, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
