package hello;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtHelloController implements HelloService {

    @Override
    public String hello(@RequestParam("name") String name) {
        return String.format("Hello, %s!", name);
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return String.format("%s is %d years old now.", user.getName(), user.getAge());
    }
}
