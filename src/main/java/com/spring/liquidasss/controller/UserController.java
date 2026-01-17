package com.spring.liquidasss.controller;

import com.spring.liquidasss.models.Product;
import com.spring.liquidasss.services.ProductService;
import com.spring.liquidasss.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(name = "/user")
public class UserController {

    private final UserService userService;
    private final ProductService productService;



}
