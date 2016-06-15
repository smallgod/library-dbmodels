/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.datawrappers;

import com.library.datamodel.Constants.APIContentType;
import com.library.datamodel.jaxb.config.v1_0.Appconfig;
import com.library.sgsharedinterface.Remote;
import com.library.sgsharedinterface.SharedAppConfigIF;
import java.util.List;

/**
 * We are implementing a wrapper since JAXB classes are ever changing, we dont
 * want a maintenance nightmare
 *
 * @author smallgod
 */
public final class AppConfigWrapper implements SharedAppConfigIF {

    private final Appconfig appConfig;
    private final String configsDir;
    private final String logsDir;
    private final String projectDir;
    private final String daemonProfile;

    /**
     *
     * @param appConfig
     * @param configsDir
     * @param logsDir
     * @param projectDir
     * @param daemonProfile
     */
    public AppConfigWrapper(Appconfig appConfig, String configsDir, String logsDir, String projectDir, String daemonProfile) {

        this.appConfig = appConfig;
        this.configsDir = configsDir;
        this.logsDir = logsDir;
        this.projectDir = projectDir;
        this.daemonProfile = daemonProfile;
    }

    @Override
    public int getHttpport() {
        return this.appConfig.getJettyServerConfigs().getHttpport();
    }

    @Override
    public int getHttpsport() {
        return this.appConfig.getJettyServerConfigs().getHttpsport();
    }

    @Override
    public int getAdminport() {
        return this.appConfig.getJettyServerConfigs().getAdminport();
    }

    @Override
    public int getOutputbuffersize() {
        return this.appConfig.getJettyServerConfigs().getOutputbuffersize();
    }

    @Override
    public int getRequestheadersize() {
        return this.appConfig.getJettyServerConfigs().getRequestheadersize();
    }

    @Override
    public int getResponseheadersize() {
        return this.appConfig.getJettyServerConfigs().getResponseheadersize();
    }

    @Override
    public String getContextpath() {
        return this.appConfig.getJettyServerConfigs().getContextpath();
    }

    @Override
    public String getResourceDirAbsPath() {
        return (getProjectDir() + this.appConfig.getJettyServerConfigs().getRelativeresourcedir());
    }

    @Override
    public String getWebxmlfile() {
        return this.appConfig.getJettyServerConfigs().getWebxmlfile();
    }

    @Override
    public String getWebappwarfile() {
        return this.appConfig.getJettyServerConfigs().getWebappwarfile();
    }

    @Override
    public String getKeystorepass() {
        return this.appConfig.getJettyServerConfigs().getKeystorepass();
    }

    @Override
    public String getKeystorepath() {
        return this.appConfig.getJettyServerConfigs().getKeystorepath();
    }

    @Override
    public String getKeystoremanagerpass() {
        return this.appConfig.getJettyServerConfigs().getKeystoremanagerpass();
    }

    @Override
    public String getWelcomefiles() {
        return this.appConfig.getJettyServerConfigs().getWelcomefiles();
    }

    @Override
    public String getLog4JpropsAbsPath() {
        return (getConfigsDir() + this.appConfig.getConfigfiles().getLog4Jprops());
    }

    /**
     * Gets the value of the hibernateprops property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getHibernatepropsAbsPath() {
        return (getConfigsDir() + this.appConfig.getConfigfiles().getHibernateprops());
    }

    @Override
    public String getAdFetcherJobName() {
        return this.appConfig.getSchedulers().getPickpending().getJobname();
    }

    @Override
    public String getAdFetcherTriggerName() {
        return this.appConfig.getSchedulers().getPickpending().getTriggername();
    }

    @Override
    public int getAdFetcherInterval() {
        return this.appConfig.getSchedulers().getPickpending().getInterval();
    }

    @Override
    public String getAdFetcherGroupName() {

        return this.appConfig.getSchedulers().getPickpending().getGroupname();

    }

    @Override
    public String getLogsDir() {
        return logsDir;
    }

    @Override
    public String getConfigsDir() {
        return configsDir;
    }

    @Override
    public String getProjectDir() {
        return projectDir;
    }

    @Override
    public String getDaemonProfile() {
        return daemonProfile;
    }

    @Override
    public int getConnTimeout() {
        return appConfig.getConntimeout();
    }

    @Override
    public int getReadTimeout() {
        return appConfig.getReadtimeout();
    }

    @Override
    public int getMaxConnections() {
        return appConfig.getMaxtotalconnections();
    }

    @Override
    public int getConnPerRoute() {
        return appConfig.getConnectionsperroute();
    }

    @Override
    public List<String> getAllowedIps() {
        return (appConfig.getAllowedips().getIp());
    }

    @Override
    public Remote getAdDisplayUnit() {
        return new RemoteUnitWrapper(appConfig.getRemoteunits().getAddisplay());
    }

    @Override
    public Remote getAdCentralUnit() {
        return new RemoteUnitWrapper(appConfig.getRemoteunits().getAdcentral());
    }

    @Override
    public Remote getAdDbManagerUnit() {
        return new RemoteUnitWrapper(appConfig.getRemoteunits().getAddbmanager());
    }

}
