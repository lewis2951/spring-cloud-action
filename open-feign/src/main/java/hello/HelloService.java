package hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "client", fallback = HelloServiceFallback.class)
public interface HelloService {

    @GetMapping("/hello")
    String hello();

    // 以下三个接口用于 Feign 声明式服务调用的参数绑定

    @GetMapping("/hello-plus-1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello-plus-2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello-plus-3")
    String hello(@RequestBody User user);

}
