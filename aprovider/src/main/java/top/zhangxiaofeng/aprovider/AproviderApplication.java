package top.zhangxiaofeng.aprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AproviderApplication.class, args);
    }

}
