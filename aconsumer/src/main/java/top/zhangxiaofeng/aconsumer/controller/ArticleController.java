package top.zhangxiaofeng.aconsumer.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ArticleController {

    @Autowired
    private RestTemplate restTemplate;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 没有@LoadBalanced，写死，有的话，使用callHello2
     *
     * @return
     */
    //@GetMapping("/article/callHello")
    //public String callHello(){
    //    return restTemplate.getForObject("http://localhost:8081/user/hello",String.class);
    //}
    //@GetMapping("/article/callHello")
    @GetMapping("/user/hello")
    public String callHello2() {
        return restTemplate.getForObject("http://eureka-client-user-service/user/hello", String.class);
    }

    @GetMapping("/article/infos")
    public Object serviceUrl() {
        return eurekaClient.getInstancesByVipAddress("eureka-client-user-service", false);
    }

    /**
     * Spring cloud重新封装的，路径是org.springframework.cloud.client.discovery.DiscoveryClient
     *
     * @return
     */
    @GetMapping("/article/infos1")
    public Object serviceUrl1() {
        return discoveryClient.getInstances("eureka-client-user-service");
    }
}
