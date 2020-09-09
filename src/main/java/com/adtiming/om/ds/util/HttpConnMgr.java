// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @description http conn mgr
 */
public class HttpConnMgr {

    private static final Logger logger = LogManager.getLogger();
    private static final int HTTP_CONNECTION_TIMEOUT = 5000;
    private static final int HTTP_REQUEST_TIMEOUT = 30000;
    private static final int SOCKET_TIMEOUT = 30000;
    public static RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(HTTP_CONNECTION_TIMEOUT)
            .setConnectTimeout(HTTP_REQUEST_TIMEOUT)
            .setSocketTimeout(SOCKET_TIMEOUT)
            .build();
    public static PoolingHttpClientConnectionManager httpClientPoolMgr = null;
    private static HttpClient httpsClient;
    private static HttpClient httpClient;
    private static SSLContext sslcontext = createSSLContext();
    private static SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
            sslcontext, (paramString, paramSSLSession) -> true);

    static {
        init();
    }

    private HttpConnMgr() {
        super();
    }

    public static HttpClient getHttpsClient() {
        return httpsClient;
    }

    public static HttpClient getHttpClient() {
        return httpClient;
    }

    private static void init() {
        try {
            Registry<ConnectionSocketFactory> socketFactoryRegistry =
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("https", sslsf)
                            .register("http", new PlainConnectionSocketFactory())
                            .build();
            httpClientPoolMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            httpClientPoolMgr.setMaxTotal(10000000);
            httpClientPoolMgr.setDefaultMaxPerRoute(50000);

            httpsClient = createSSLInsecureClient();
            httpClient = createHttpClient();
        } catch (Exception e) {
            logger.error("init PoolingHttpClientConnectionManager Error" + e);
        }
    }

    /**
     * 获取Http 请求客户端
     */
    private static CloseableHttpClient createHttpClient() {
        CloseableHttpClient httpclient =
                HttpClients.custom().setConnectionManager(httpClientPoolMgr)
                        .setDefaultRequestConfig(requestConfig).build();
        return httpclient;
    }

    /**
     *
     */
    private static CloseableHttpClient createSSLInsecureClient() {
        CloseableHttpClient httpsClient = HttpClients.custom()
                .setConnectionManager(httpClientPoolMgr)
                .setDefaultRequestConfig(requestConfig)
                .setSSLSocketFactory(sslsf).build();
        return httpsClient;
    }

    /**
     * init SslContext
     *
     * @return
     */
    private static SSLContext createSSLContext() {
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null,
                    new TrustManager[]{new TrustAnyTrustManager()},
                    new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            logger.error("Https_createSSLContext_exception:", e);
        } catch (KeyManagementException e) {
            logger.error("Https_createSSLContext_KeyManagementException:", e);
        }
        return sslcontext;
    }

    /**
     *
     */
    private static class TrustAnyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            logger.warn("Untrust_domain!");
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            logger.warn("Untrust_domain_checkServerTrusted!");
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            logger.warn("Untrust_domain_X509Certificate!");
            return null;
        }
    }
}
