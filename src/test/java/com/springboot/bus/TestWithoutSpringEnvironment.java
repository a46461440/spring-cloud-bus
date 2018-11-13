package com.springboot.bus;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class TestWithoutSpringEnvironment {

    @Test
    public void testPostToActuatorRefresh() {
        new RestTemplate().postForEntity("http://10.122.3.207:5555/actuator/bus-refresh/spring-cloud-bus",new HashMap(),Void.class);
    }

}
