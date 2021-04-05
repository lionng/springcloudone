package top.zhangxiaofeng.springresttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.zhangxiaofeng.springresttemplate.dto.HouseInfo;

@RestController
public class HouseClientController {

    @Autowired
    private RestTemplate restTemplate;

    //@GetMapping("/call/data")
    //public HouseInfo getData(@RequestParam("name") String name) {
    //    return restTemplate.getForObject("http://localhost:8083/house/data?name=" + name, HouseInfo.class);
    //}

    /**
     * BeanConfiguration类中的@LoadBalanced需要加上
     * @param name
     * @return
     */
    @GetMapping("/call/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://ribbon-eureka-demo/house/data?name=" + name, HouseInfo.class);
    }

    /**
     * BeanConfiguration类中的@LoadBalanced需要加上
     * @param name
     * @return
     */
    @GetMapping("call/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://ribbon-eureka-demo/house/data/{name}", String.class, name);
    }

    /**
     * BeanConfiguration类中的@LoadBalanced需要注释掉
     * @param name
     * @return
     */
    @GetMapping("call/dataEntity")
    public HouseInfo getData3(@RequestParam("name") String name) {
        ResponseEntity<HouseInfo> responseEntity = restTemplate
                .getForEntity("http://ribbon-eureka-demo/house/data?name=" + name, HouseInfo.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            return responseEntity.getBody();
        }
        return null;
    }

    @GetMapping("call/save")
    public Long add() {
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setCity("上海");
        houseInfo.setRegion("虹口");
        houseInfo.setName("明珠");
        Long id = restTemplate.postForObject("http://ribbon-eureka-demo/house/save", houseInfo, Long.class);
        return id;
    }
}
