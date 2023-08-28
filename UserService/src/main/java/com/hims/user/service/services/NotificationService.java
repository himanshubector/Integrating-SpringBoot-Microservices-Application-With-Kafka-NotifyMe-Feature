package com.hims.user.service.services;


import java.util.List;
import java.util.Set;

public interface NotificationService
{
    public void subscribeToProductNotifications(String userId, String productId);

    Set<String> getAllProductsWithNotificationSubscription(boolean isNotified);

}
