package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixHelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hystrix/hello")
    public String hello() {
        return helloService.hello();
    }

}
