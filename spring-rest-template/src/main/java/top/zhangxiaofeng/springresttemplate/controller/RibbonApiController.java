package top.zhangxiaofeng.springresttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonApiController {
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/choose")
    public Object chooseUrl(){
        ServiceInstance instance = loadBalancer.choose("ribbon-eureka-demo");
        return instance;
    }
}
