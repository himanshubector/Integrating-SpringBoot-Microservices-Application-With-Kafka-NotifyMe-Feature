package com.hims.product.service.repositories;


import com.hims.product.service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer>
{


}
