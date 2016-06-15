/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.Constants;

/**
 *
 * @author smallgod
 */
public interface NamedConstants {

    /**
     * All JSON request strings must have a root node named 'method' which
     * identifies the name of the API method being called
     */
    public static final String JSON_METHOD_NODENAME = "method";

    /**
     * All JSON request strings must have a root node named 'params' which
     * identifies the parameters of the API method being called
     */
    public static final String JSON_PARAMS_NODENAME = "params";

    /**
     * When storing appconfigs in the servlet context, we will use this as the
     * attribute name
     */
    public static final String APPCONFIGS_ATTR_NAME = "appconfigs";

    /**
     * When storing the database reference in the servlet context, we will use
     * this as the attribute name
     */
    public static String DATABASE_ATTR_NAME = "dbreference";

    /**
     * When storing the http pool reference in the servlet context, we will use
     * this as the attribute name
     */
    public static String HTTP_POOL_ATTR_NAME = "httppool";

    /**
     * A username that last modified a given auditable database entity
     */
    public static final String PROPNAME_LAST_MODIFIED_BY = "lastModifiedBy";

    /**
     * A date when a given auditable database entity was modified
     */
    public static final String PROPNAME_DATE_LAST_MODIFIED = "dateLastModified";

    /**
     * A delimited string with a trail of dates when an auditable database
     * entity has been modified
     */
    public static final String PROPNAME_DATE_MODIFIED_HISTORY = "dateModifiedHistory";
    /**
     * A delimited string with a trail of usernames that have modified an
     * auditable database entity
     */
    public static final String PROPNAME_MODIFIED_BY_HISTORY = "modifiedByHistory";

    /**
     * A username that first created a given auditable database entity
     */
    public static final String PROPNAME_CREATED_BY = "createdBy";

    /**
     * A date when a given auditable database entity was first created
     */
    public static final String PROPNAME_CREATED_ON = "createdOn";

    /**
     * same as the JDBC batch size in the hibernate config xml config file Will
     * flush a batch of inserts and release memory
     */
    public static final int HIBERNATE_JDBC_BATCH = 30;

    /**
     * The batch size for number of records to be read at a time
     */
    public static final int NUM_ROWS_CHUNK = 10000;

    /**
     * Profile under which the daemon has been started and is running -
     * Development profile
     */
    public static final String DAEMON_PROFILE_DEV = "development";

    /**
     * Profile under which the daemon has been started and is running -
     * Production profile
     */
    public static final String DAEMON_PROFILE_PROD = "production";

    /**
     * Profile under which the daemon has been started and is running - Staging
     * profile
     */
    public static final String DAEMON_PROFILE_STAGE = "staging";

    /**
     * Http header value for the JSON content type
     */
    //public static final String HTTP_CONTENT_TYPE_JSON = "application/json"; //"application/json;charset=UTF-8")

    /**
     * Http header value for the XML content type
     */
    //public static final String HTTP_CONTENT_TYPE_XML = "application/xml";

    /**
     * An http server can return a success http response but with no content in
     * the body
     */
    public static final int HTTPCODE_SUCCESS_NO_CONTENT = 204;

    /**
     * HTTP requestmethod - POST
     */
    public static final String HTTP_REQUESTMETHOD_POST = "POST";
    /**
     * HTTP requestmethod - GET
     */
    public static final String HTTP_REQUESTMETHOD_GET = "GET";
    
    /**
     * Attribute name for the http parameter name holding the database entity name/type
     * useful when passing a request to the DB manager unit, so that the entity in context
     * can be idenitified
     */
    public static final String HTTP_PARAM_ENTITYNAME = "entityname";

}
