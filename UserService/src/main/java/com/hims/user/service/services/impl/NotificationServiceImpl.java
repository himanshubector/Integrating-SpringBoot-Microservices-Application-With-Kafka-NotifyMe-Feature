package com.hims.user.service.services.impl;


import com.hims.user.service.entities.Notification;
import com.hims.user.service.entities.User;
import com.hims.user.service.repositories.NotificationRepository;
import com.hims.user.service.services.NotificationService;
import com.hims.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class NotificationServiceImpl implements NotificationService
{
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationRepository notificationRepository;

    public void subscribeToProductNotifications(String userId, String productId)
    {

        Notification notification = new Notification();

        notification.setProductId(productId);

        User userDetail = userService.getUserById(userId);

        notification.setUser(userDetail);


        notificationRepository.save(notification);


    }


    public Set<String> getAllProductsWithNotificationSubscription(boolean isNotified)
    {

        List<Notification> userSubscribedNotifications = this.notificationRepository.findByIsNotifiedFalse();


        Set<String> userSubscribedProductIds = userSubscribedNotifications.stream().map(notification -> notification.getProductId()).collect(Collectors.toSet());


        return userSubscribedProductIds;

    }


}
