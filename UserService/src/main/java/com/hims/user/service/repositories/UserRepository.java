package com.hims.user.service.repositories;


import com.hims.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>
{

    // if we want to implement any custom method or query


}
