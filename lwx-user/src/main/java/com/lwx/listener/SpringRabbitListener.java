package com.lwx.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SpringRabbitListener {

    /*@RabbitListener(queues = "lwx-test")
    public void listenSimple(String test) {
        System.out.println("接受消息成功："+ test);
    }*/

    /**
     * ListenWorkQueue模式
     * @param test
     * @throws InterruptedException
     */
    @RabbitListener(queues = "lwx-test")
    public void listenWork(String test) throws InterruptedException {
        System.out.println("消费者1接受消息成功："+ test + LocalTime.now());
        Thread.sleep(20);
    }
    @RabbitListener(queues = "lwx-test")
    public void listenWork1(String test) throws InterruptedException {
        System.err.println("消费者2接受消息成功："+ test + LocalTime.now());
        Thread.sleep(200);
    }

    /**
     * fanoutExchange 模式
     * 可以通过下面的写法，那样更简单
     * @param test
     */
    @RabbitListener(queues = "lwx-queue1")
    public void listenFanoutQueue1(String test) {
        System.out.println("接受FanoutQueue1消息成功："+ test);
    }
    @RabbitListener(queues = "lwx-queue2")
    public void listenFanoutQueue2(String test) {
        System.out.println("接受FanoutQueue2消息成功："+ test);
    }


    /**
     * DirectExchange 模式
     * 只是在fanoutExchange模式上添加了一个route key控制发送的指定方向，接收者用key指定接收
     * @param test
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "direct.queue1"),exchange = @Exchange(name = "lwx-direct", type = ExchangeTypes.DIRECT),key = {"red", "blue"}))
    public void listenDirectQueue1(String test) {
        System.out.println("接受DirectExchangeQueue1消息成功："+ test);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "direct.queue2"),exchange = @Exchange(name = "lwx-direct", type = ExchangeTypes.DIRECT),key = {"red", "yellow"}))
    public void listenDirectQueue2(String test) {
        System.out.println("接受DirectExchangeQueue2消息成功："+ test);
    }

    /**
     * Topic Exchange 模式
     * 跟DirectExchange 差不多只是key的写法不一样 用 . 分隔
     * @param test
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic.queue1"), exchange = @Exchange(name = "lwx-topic", type = ExchangeTypes.TOPIC), key = "china.#"))
    public void listenTopicQueue1(String test) {
        System.out.println("接受TopicExchangeQueue1消息成功："+ test);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic.queue2"), exchange = @Exchange(name = "lwx-topic", type = ExchangeTypes.TOPIC), key = "chna.news"))
    public void listenTopicQueue2(String test) {
        System.out.println("接受TopicExchangeQueue2消息成功："+ test);
    }

}
