package com.hims.user.service.services;


import com.hims.user.service.entities.User;

public interface UserService
{
    void subscribeToProductNotifications(String userId, String productId);


    User getUserById(String userId);

}
