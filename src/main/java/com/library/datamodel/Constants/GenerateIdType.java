package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.sglogger.util.LoggerUtil;

/**
 * 
 * @author smallgod
 */
public enum GenerateIdType implements Constants {

    LONG("LONG"),
    INTEGER("INTEGER");
    
    private final String generateIdType;

    private static final LoggerUtil logger = new LoggerUtil(GenerateIdType.class);

    GenerateIdType(String generateIdType) {
        this.generateIdType = generateIdType;
    }

    @Override
    public String getValue() {
        return this.generateIdType;
    }

    public static GenerateIdType convertToEnum(String generateIdTypeValue) {

        if (generateIdTypeValue != null) {

            for (GenerateIdType adStatusEnum : GenerateIdType.values()) {

                if (generateIdTypeValue.equalsIgnoreCase(adStatusEnum.getValue())) {
                    return adStatusEnum;
                }
            }
        }
        logger.warn("No constant with text " + generateIdTypeValue + " found");
        throw new IllegalArgumentException("No constant with text " + generateIdTypeValue + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + generateIdTypeValue, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
