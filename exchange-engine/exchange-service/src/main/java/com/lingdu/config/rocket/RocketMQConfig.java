package com.lingdu.config.rocket;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableBinding(value = Source.class)
@EnableBinding(value = {Sinkk.class,Source.class})
public class RocketMQConfig {
}
