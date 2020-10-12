package top.zhangxiaofeng.aprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "top.zhangxiaofeng.aprovider.apiclient")
public class AproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AproviderApplication.class, args);
    }

}
