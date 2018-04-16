package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String hello() {
        client.getInstances("hello-service").forEach(instance -> logger.info("host: {}, serviceId: {}", instance.getHost(), instance.getServiceId()));
        logger.info(client.description());
        client.getServices().forEach(logger::info);
        return "Hello, World!";
    }

    // 以下三个接口用于 Feign 声明式服务调用的参数绑定

    @GetMapping("/hello-plus-1")
    public String hello(@RequestParam("name") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/hello-plus-2")
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @PostMapping("/hello-plus-3")
    public String hello(@RequestBody User user) {
        return String.format("%s is %d years old now.", user.getName(), user.getAge());
    }

}
