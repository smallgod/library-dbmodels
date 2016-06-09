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
     * All JSON request strings must have a root node named 'method' which identifies the 
     * name of the API method being called
     */
    public static final String JSON_METHOD_NODENAME = "method";
    
    /**
     * All JSON request strings must have a root node named 'params' which identifies the 
     * parameters of the API method being called
     */
    public static final String JSON_PARAMS_NODENAME = "params";
    
    /**
     * When storing appconfigs in the servlet context, we will use this as the attribute name
     */
    public static final String APPCONFIGS_ATTR_NAME = "appconfigs";
}
