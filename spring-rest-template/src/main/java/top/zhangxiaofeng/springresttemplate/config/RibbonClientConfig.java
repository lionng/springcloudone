package top.zhangxiaofeng.springresttemplate.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "ribbon-eureka-demo",configuration = BeanConfiguration.class)
public class RibbonClientConfig {
}
