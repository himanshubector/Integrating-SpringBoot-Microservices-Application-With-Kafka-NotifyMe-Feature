package com.hims.product.service.controllers;


import com.hims.product.service.entities.Product;
import com.hims.product.service.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    private StockService stockService;


/*    @Autowired
    private ProductService productService;*/


    @PostMapping("/subscribe/product/{productId}/user/{userId}")
    public ResponseEntity<Product> subscribeForProductNotifications(@PathVariable String userId, @PathVariable String productId)
    {

        // notificationService.subscribeToProductNotifications(userId, productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


/*
    @GetMapping
    public ResponseEntity<ApiResponse> checkProductStockAvailability()
    {
        productService.checkProductStockAvailability();
        return new ResponseEntity(new ApiResponse("Product Stock Availability Checked Successfully", true), HttpStatus.OK);

    }*/

}
