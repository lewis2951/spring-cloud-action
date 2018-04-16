package hello;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/ext")
public interface HelloService {

    @GetMapping("/hello-plus-1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello-plus-2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello-plus-3")
    String hello(@RequestBody User user);

}
