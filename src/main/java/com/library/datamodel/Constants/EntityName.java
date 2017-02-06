package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum EntityName implements Constants {

    AD_SCREENOWNER("AD_SCREENOWNER"),
    AD_SCHEDULE("AD_SCHEDULE"),
    AD_RESOURCE("AD_RESOURCE"),
    AD_PROGRAM("AD_PROGRAM"),
    AD_PAYMENT("AD_PAYMENT"),
    AD_SCREEN("AD_SCREEN"),
    AD_OWNER("AD_OWNER"),
    AD_AREA("AD_AREA");

    private final String entityNameStr;

    private static final LoggerUtil logger = new LoggerUtil(EntityName.class);

    EntityName(String entityNameStr) {
        this.entityNameStr = entityNameStr;
    }

    @Override
    public String getValue() {
        return this.entityNameStr;
    }

    public static EntityName convertToEnum(String entityName) {

        if (entityName != null) {

            for (EntityName availableEntityName : EntityName.values()) {

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
