package yooxinz.springcloud.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "config-client")
public interface ConfigRpc {

    @RequestMapping("/")
    String hi();
}
