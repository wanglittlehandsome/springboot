package com.bestway.program.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * httpclient调用配置
 */
@Configuration
@PropertySource("classpath:config.properties")
public class HttpInvokeConfiguration {

    @Value("${http.mobile.code}")
    private String CODE;
    @Value("${http.mobile.login}")
    private String LOGIN;

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }
}
