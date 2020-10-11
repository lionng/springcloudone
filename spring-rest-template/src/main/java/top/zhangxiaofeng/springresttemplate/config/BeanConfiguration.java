package top.zhangxiaofeng.springresttemplate.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    @LoadBalanced
    //@MyLoadBalanced
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }
}
