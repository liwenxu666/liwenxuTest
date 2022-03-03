package com.lwx.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("lwx-fanout");
    }

    @Bean
    public Queue fanOutQueue1() {
        return new Queue("lwx-queue1");
    }

    @Bean
    public Binding fanoutBinding1(Queue fanOutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanOutQueue1).to(fanoutExchange);
    }

    @Bean
    public Queue fanOutQueue2() {
        return new Queue("lwx-queue2");
    }

    @Bean
    public Binding fanoutBinding2(Queue fanOutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanOutQueue2).to(fanoutExchange);
    }


}
