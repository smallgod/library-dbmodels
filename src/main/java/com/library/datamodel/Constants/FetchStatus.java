package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.sglogger.util.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum FetchStatus implements Constants {

    FETCHED("FETCHED"),
    TO_FETCH("TO_FETCH");

    private final String entityNameStr;

    private static final LoggerUtil logger = new LoggerUtil(FetchStatus.class);

    FetchStatus(String entityNameStr) {
        this.entityNameStr = entityNameStr;
    }

    @Override
    public String getValue() {
        return this.entityNameStr;
    }

    public static FetchStatus convertToEnum(String entityName) {

        if (entityName != null) {

            for (FetchStatus availableEntityName : FetchStatus.values()) {

                if (entityName.equalsIgnoreCase(availableEntityName.getValue())) {
                    return availableEntityName;
                }
            }
        }
        logger.warn("No constant with text " + entityName + " found");
        throw new IllegalArgumentException("No constant with text " + entityName + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + entityName, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
