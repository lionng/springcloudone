package top.zhangxiaofeng.aprovider.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import top.zhangxiaofeng.aprovider.config.FeignConfiguration;

@FeignClient(value = "eureka-client-user-service", configuration = FeignConfiguration.class)
public interface UserRemoteClient {
    @GetMapping("/user/hello")
    String hello();
}