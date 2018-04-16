package hello;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "client-ext", fallback = ExtHelloServiceFallback.class)
public interface ExtHelloService extends HelloService {

}
