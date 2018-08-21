package com.involves.selecao.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClientHelper {

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    private void setContentTypeApplicationJson() {
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    private void setToken(String token) {
        if (token == null) return;
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }

    public ResponseEntity<String> doPost(String uri, String objectJson) throws RestClientException {
        return execute(HttpMethod.POST, uri, null, objectJson);
    }

    public ResponseEntity<String> doPost(String uri, String token, String objectJson) throws RestClientException {
        return execute(HttpMethod.POST, uri, token, objectJson);
    }

    public ResponseEntity<String> doGet(String uri, String token) throws RestClientException {
        return execute(HttpMethod.GET, uri, token, "");
    }

    public ResponseEntity<String> doPut(String uri, String token, String objectJson) throws RestClientException {
        return execute(HttpMethod.PUT, uri, token, objectJson);
    }

    private ResponseEntity<String> execute(HttpMethod method, String uri, String token, String objectJson) throws RestClientException {
        this.setContentTypeApplicationJson();
        this.setToken(token);
        HttpEntity<String> entity = new HttpEntity<String>(objectJson, headers);
        return restTemplate.exchange(uri, method, entity, String.class);
    }
}