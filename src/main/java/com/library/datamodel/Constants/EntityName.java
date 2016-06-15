package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author smallgod
 */
public enum EntityName implements Constants {

    ADVERT("ADVERT"),
    TARGET_AREA("TARGET_AREA"),
    AD_OWNER("AD_OWNER");
    
    private final String entityNameStr;

    private static final Logger logger = LoggerFactory.getLogger(EntityName.class);

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
