package com.library.datamodel.Constants;

import com.library.customexception.MyCustomException;
import com.library.sgsharedinterface.Constants;
import com.library.utilities.GeneralUtils;

/**
 *
 * @author smallgod
 */
public enum EntityName implements Constants {

    TIME_SLOT("TIME_SLOT"),
    LOCATION_TYPE("LOCATION_TYPE"),
    AUDIENCE_TYPE("AUDIENCE_TYPE"),
    AD_SCREENOWNER("AD_SCREENOWNER"),
    AD_SCHEDULE("AD_SCHEDULE"),
    AD_TERMINAL("AD_TERMINAL"),
    AD_RESOURCE("AD_RESOURCE"),
    AD_PROGRAM("AD_PROGRAM"),
    AD_PAYMENT("AD_PAYMENT"),
    AD_MONITOR("AD_MONITOR"),
    AD_SCREEN("AD_SCREEN"),
    AD_CLIENT("AD_CLIENT"),
    AD_OWNER("AD_OWNER"),
    AD_AREA("AD_AREA"),
    AD_TEXT("AD_TEXT"),
    AUTHOR("AUTHOR"),
    BOOK("BOOK");

    private final String entityNameStr;

    EntityName(String entityNameStr) {
        this.entityNameStr = entityNameStr;
    }

    @Override
    public String getValue() {
        return this.entityNameStr;
    }

    public static EntityName convertToEnum(String entityName) throws MyCustomException {

        if (entityName != null) {

            for (EntityName availableEntityName : EntityName.values()) {

                if (entityName.equalsIgnoreCase(availableEntityName.getValue())) {
                    return availableEntityName;
                }
            }
        }

        MyCustomException error = GeneralUtils.getSingleError(ErrorCode.NOT_SUPPORTED_ERR, "Unsupported Entity Name", "Failed to convert entity name: " + entityName + "to Enum");

        throw error;

    }
}
