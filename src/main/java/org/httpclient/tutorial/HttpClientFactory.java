package org.httpclient.tutorial;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.httpclient.tutorial.utils.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by yushi on 8/7/15.
 */
@Component
public final class HttpClientFactory {

    private ConstantUtil constantUtil;

    @Autowired
    public HttpClientFactory(ConstantUtil constantUtil) {

        this.constantUtil = constantUtil;
    }

    public CloseableHttpClient createHttpClient() {
        return HttpClients.createDefault();
    }

    public HttpClientBuilder createHttpClientWithProxy() {

        HttpHost proxy = new HttpHost(constantUtil.getProxyHost(), constantUtil.getProxyPort());
        Credentials credentials = new UsernamePasswordCredentials(constantUtil.getProxyUser(), constantUtil.getProxyPassword());
        AuthScope authScope = new AuthScope(constantUtil.getProxyHost(), constantUtil.getProxyPort());
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(authScope, credentials);

        return HttpClients.custom().setDefaultCredentialsProvider(credentialsProvider).setProxy(proxy);
    }
}
