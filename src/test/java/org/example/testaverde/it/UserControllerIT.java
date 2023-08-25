package org.example.testaverde.it;

import org.example.testaverde.MainApplication;
import org.json.JSONException;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIT {

    @LocalServerPort private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @Test
    public void testRetrieveUser1() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<>(null,headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createUrlWithPort("/users/1"), HttpMethod.GET, entity, String.class
        );
        String expected = "{\"id\":1,\"name\":\"admin\",\"email\":\"admin@example.com\",\"adminRole\":\"1\"}";
        JSONAssert.assertEquals(expected,response.getBody(), false);
    }

    private String createUrlWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
