package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.LoggerUtil;

/**
 *
 * @author smallgod
 */
public enum DbOperation implements Constants {

    SAVE_SINGLE("save"),
    READ_SINGLE("read"),
    SAVE_BULK("savebulk"),
    READ_BULK("readbulk"),
    DELETE_SINGLE("delete"),
    DELETE_BULK("deletebulk"),
    UPDATE_ENTITY("updateentity"),
    PROCESS_AND_SAVE("processandsave");

    private final String entityNameStr;

    private static final LoggerUtil logger = new LoggerUtil(DbOperation.class);

    DbOperation(String entityNameStr) {
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
