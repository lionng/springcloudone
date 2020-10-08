package top.zhangxiaofeng.aconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AconsumerApplication.class, args);
    }

}
