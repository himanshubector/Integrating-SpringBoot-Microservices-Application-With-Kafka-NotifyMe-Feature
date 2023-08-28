package com.hims.user.service.services.impl;


import com.hims.user.service.entities.Notification;
import com.hims.user.service.entities.User;
import com.hims.user.service.payloads.StockInfo;
import com.hims.user.service.repositories.NotificationRepository;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Slf4j
public class StockCheckConsumerServiceImpl
{
    @Autowired
    private EmailServiceImpl emailService;


    @Autowired
    private NotificationRepository notificationRepository;



    // @KafkaListener(topics = "stock-topic", groupId = "myGroup") // this also works fine even if we provide group-id here as well as in application.yml file
    @KafkaListener(topics = "stock-topic") // group-id is already provided in application.yml file so no need to provide here
    public void consume(StockInfo stockInfo) throws IOException
    {
        log.info("Message received from Kafka Topic : {}", stockInfo);


        int productId = stockInfo.getProductId();

        boolean productInStock = stockInfo.isAvailable();


       // Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found...."));


       // this.notificationRepository.findByProductId().orElseThrow(() -> new RuntimeException("Notification not found...."));


        List<Notification> notifications = this.notificationRepository.findByProductId(String.valueOf(productId));

        Set<User> usersSet = notifications.stream().map(notification -> notification.getUser()).collect(Collectors.toSet());



      /*  productIdSet.stream().forEach(productId -> {
            Stock stock = stockRepository.findByProductProductId(Integer.valueOf(productId));
            publishProductAvailability(stock);
        });*/


        usersSet.stream().forEach(user -> {
                    sendEmailNotification(user);
                });


    }


    private void sendEmailNotification(User user)
    {
        emailService.send(user.getEmail(), "Product back in stock", "The product "+"product.getProductName()"+" is now back in stock");

        System.out.println("Email sent successfully ###########");

    }

}
