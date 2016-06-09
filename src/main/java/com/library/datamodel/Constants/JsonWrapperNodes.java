package com.library.datamodel.Constants;

//import com.advertexpo.addisplay.exceptiontype.MyCustomException;
import com.library.sgsharedinterface.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the different states a processing unit such as a monitoring unit or AdDisplay unit 
 * could be in at any one moment
 * @author smallgod
 */
public enum JsonWrapperNodes implements Constants {

    WAKEUP_REQUEST("WAKEUP_REQUEST"),
    FETCH_REQUEST("ADFETCH_REQUEST");
    
    private final String wrapperNodeStr;

    private static final Logger logger = LoggerFactory.getLogger(JsonWrapperNodes.class);

    JsonWrapperNodes(String wrapperNodeStr) {
        this.wrapperNodeStr = wrapperNodeStr;
    }

    @Override
    public String getValue() {
        return this.wrapperNodeStr;
    }

    public static JsonWrapperNodes convertToEnum(String wrapperNodeVal) {

        if (wrapperNodeVal != null) {

            for (JsonWrapperNodes availableNodes : JsonWrapperNodes.values()) {

                if (wrapperNodeVal.equalsIgnoreCase(availableNodes.getValue())) {
                    return availableNodes;
                }
            }
        }
        logger.warn("No constant with text " + wrapperNodeVal + " found");
        throw new IllegalArgumentException("No constant with text " + wrapperNodeVal + " found");
        //throw new MyCustomException("Unsupported Status Exception", ErrorCode.NOT_SUPPORTED_ERR, "Unsupported status value :: " + wrapperNodeVal, ErrorCategory.CLIENT_ERR_TYPE);

    }
}
