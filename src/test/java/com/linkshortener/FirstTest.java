package com.linkshortener;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FirstTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @AfterAll
    public static void afterAll() {

    }

    @ParameterizedTest
    @ArgumentsSource(PayloadPostProvider.class)
    public void postRequestTest(String payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity("http://localhost:" + port + "/url", entity, Map.class);
        System.out.println(response.getStatusCode());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @ParameterizedTest
    @ArgumentsSource(PayloadGetProvider.class)
    public void getRequestTest(String payload) {

        ResponseEntity<Map> response = restTemplate.getForEntity("http://localhost:" + port + "/" + payload, Map.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @ParameterizedTest
    @ArgumentsSource(PayloadPostProvider.class)
    public void postRequestStatisticTest(String payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<List> response = restTemplate.postForEntity("http://localhost:" + port + "/statistic", entity, List.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        int a = 4;
    }
}