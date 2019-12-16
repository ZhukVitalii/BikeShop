package beetle.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UserControllerTest{
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getHello() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/").toString(), String.class);
        assertEquals("Hello Controller", response.getBody());

    }


}