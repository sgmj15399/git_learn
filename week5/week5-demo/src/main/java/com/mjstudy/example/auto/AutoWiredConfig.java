package com.mjstudy.example.auto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动注解方式，Bean装配
 */
@Configuration
public class AutoWiredConfig {

    @Bean
    public AutoWiredDemo autoWiredDemo(){
        return new AutoWiredDemo();
    }
}
