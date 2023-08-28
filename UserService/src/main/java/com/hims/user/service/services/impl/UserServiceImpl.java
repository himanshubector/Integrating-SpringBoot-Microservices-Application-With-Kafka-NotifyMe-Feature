package com.hims.user.service.services.impl;


import com.hims.user.service.entities.User;
import com.hims.user.service.repositories.UserRepository;
import com.hims.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;


    // User subscription management logic



    public void subscribeToProductNotifications(String userId, String productId)
    {
        // Add productId to user's subscribed products
    }



   /* public void unsubscribeFromProductNotifications(String userId, String productId)
    {
        // Remove productId from user's subscribed products
    }*/


    public User getUserById(String userId)
    {
        User userDetail = userRepository.findById(Integer.valueOf(userId)).orElseThrow(() -> new RuntimeException("User not found"));

        return userDetail;

    }

}
