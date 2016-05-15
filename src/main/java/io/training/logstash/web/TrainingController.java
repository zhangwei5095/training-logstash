package io.training.logstash.web;

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

}
