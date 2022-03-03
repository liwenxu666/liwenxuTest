package com.lwx.controller;

import com.lwx.client.UserClient;
import com.lwx.pojo.Order;
import com.lwx.pojo.User;
import com.lwx.service.OrderService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private UserClient userClient;


    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("getOrderById/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("getUserById1/{id}")
    public User getUserById(@PathVariable("id") int id) {

        return userClient.getUser(id);
    }

    /**
     * simple 发送方法
     */
    @GetMapping("amqpTest")
    public void amqpTest() {
        rabbitTemplate.convertAndSend("lwx-test","adsadasdsadasd");
    }

    /**
     * Work QUEUE 发送方法
     * @throws InterruptedException
     */
    @GetMapping("amqpTest1")
    public void amqpTest1() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend("lwx-test","发送数据：" + i);
            Thread.sleep(20);
        }
    }

    /**
     * Fanout Exchange方式发送
     */
    @GetMapping("amqpTest2")
    public void amqpTest2()  {
        //交换机名称
        String exchangeName = "lwx-fanout";
        rabbitTemplate.convertAndSend(exchangeName,"","dasdasdasdasdasdsadasdadad");
    }

    /**
     * Direct Exchange方式发送
     */
    @GetMapping("amqpTest3")
    public void amqpTest3(){
        //交换机名称
        String exchangeName = "lwx-direct";

        rabbitTemplate.convertAndSend(exchangeName,"yellow", "directe  test");
    }

    /**
     * Topic Exchange方式发送
     */
    @GetMapping("amqpTest4")
    public void amqpTest4(){
        //交换机名称
        String exchangeName = "lwx-topic";
        rabbitTemplate.convertAndSend(exchangeName,"1.news", "topic  test");
    }


}
