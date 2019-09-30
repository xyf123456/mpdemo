package com.bdqn.mp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @ClassName: com.bdqn.mp.config.LimitConfig
 * @Description: 配置文件中的属性
 * @Author:      Administrator
 * @CreateDate: 2019/9/1 0001 下午 10:57
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@Component
@Data
@ConfigurationProperties(prefix = "limit")
public class LimitConfig {

        private BigDecimal minMoney;
        private BigDecimal maxMoney;
        private String description;

}
