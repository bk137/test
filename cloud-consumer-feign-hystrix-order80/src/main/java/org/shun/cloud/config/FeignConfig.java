package org.shun.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Administrator
 * 日志增强
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerlevel(){
        return Logger.Level.FULL;
    }
}
