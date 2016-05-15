package io.training.logstash.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.training.logstash.service.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试logstash输出到logback中
 * <p>
 * Created by percy on 16-5-14.
 */
@RestController
public class TrainingController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test")
    public String test(String name) {
        log.info("记录输入日志：{}", name);
        return "测试日志输出：" + name;
    }

    @RequestMapping("/test-json")
    public String testJson(String name) {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setId(1L);
        user.setName("Hello");
        String result = "";
        try {
            result = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info(result);
        return "测试日志输出：" + name;
    }

}
