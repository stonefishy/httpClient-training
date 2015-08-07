package org.httpclient.tutorial.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by yushi on 8/7/15.
 */
@Component
public final class ConstantUtil {

    private static final String PROXY_HOST = "proxy.host";
    private static final String PROXY_PORT = "proxy.port";
    private static final String PROXY_USER = "proxy.user";
    private static final String PROXY_PASSWORD = "proxy.password";

    private Properties configurationProperties;


    @Autowired
    public ConstantUtil(Properties configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    public String getProxyHost() {
        return this.configurationProperties.getProperty(PROXY_HOST);
    }

    public int getProxyPort() {
        return Integer.parseInt(this.configurationProperties.getProperty(PROXY_PORT));
    }

    public String getProxyUser() {
        return this.configurationProperties.getProperty(PROXY_USER);
    }

    public String getProxyPassword() {
        return this.configurationProperties.getProperty(PROXY_PASSWORD);
    }
}
