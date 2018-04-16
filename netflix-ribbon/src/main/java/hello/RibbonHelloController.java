package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonHelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon/hello")
    public String hello() {
        return this.restTemplate.getForEntity("http://client/hello", String.class).getBody();
    }

}
