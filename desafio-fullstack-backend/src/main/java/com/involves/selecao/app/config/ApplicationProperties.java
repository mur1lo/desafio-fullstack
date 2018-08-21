package com.involves.selecao.app.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private String urlProcessarAlertas;

    public String getUrlProcessarAlertas() {
        return urlProcessarAlertas;
    }

    public void setUrlProcessarAlertas(String urlProcessarAlertas) {
        this.urlProcessarAlertas = urlProcessarAlertas;
    }
}

