package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/feign/hello")
    public String hello() {
        return helloService.hello();
    }

    @GetMapping("/feign/hello-plus")
    public String helloPlus() {
        StringBuilder sb = new StringBuilder();

        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("Spring Cloud")).append("\n");
        sb.append(helloService.hello("Spring Cloud", 3)).append("\n");
        sb.append(helloService.hello(new User("Spring Cloud", 3))).append("\n");

        return sb.toString();
    }

}
