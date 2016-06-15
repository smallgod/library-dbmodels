package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author smallgod
 */
public enum DbOperation implements Constants {

    SAVE("SAVE_SINGLE", Boolean.FALSE),
    SAVE("SAVE_MULTIPE", Boolean.TRUE),
    READ_SINGLE("READ_SINGLE"),
    READ_MULTIPE("READ_MULTIPE"),
    DELETE_SINGLE("DELETE_SINGLE"),
    DELETE_MULTIPLE("DELETE_MULTIPLE");
    
    private final String entityNameStr;

    private static final Logger logger = LoggerFactory.getLogger(DbOperation.class);

    DbOperation(String entityNameStr, boolean multiple) {
        this.entityNameStr = entityNameStr;
    }

    @Override
    public String getValue() {
        return this.entityNameStr;
    }

    public static DbOperation convertToEnum(String entityName) {

        if (entityName != null) {

            for (DbOperation availableEntityName : DbOperation.values()) {

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
