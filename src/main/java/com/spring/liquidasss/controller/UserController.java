package com.spring.liquidasss.controller;

import com.spring.liquidasss.models.Product;
import com.spring.liquidasss.models.User;
import com.spring.liquidasss.services.ProductService;
import com.spring.liquidasss.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/register")
    public String registerUser(){
       return "register.html";
    }

    @GetMapping("/login")
    public ModelAndView userlogin(@RequestParam(required = false) String error) {
        ModelAndView mv = new ModelAndView("userLogin");
        if ("true".equals(error)) {
            mv.addObject("msg", "Please enter correct email and password");
        }
        return mv;
    }

    @GetMapping("/")
    public ModelAndView indexPage()
    {
        ModelAndView mView  = new ModelAndView("index");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        mView.addObject("username", username);
        List<Product> products = this.productService.getProducts();

        if (products.isEmpty()) {
            mView.addObject("msg", "No products are available");
        } else {
            mView.addObject("products", products);
        }
        return mView;
    }

    @PostMapping(value = "/newuserregister")
    public String newUserRegister(@RequestBody User user) {
        boolean exists = this.userService.checkUserExists(user.getUsername());

        if(!exists){
            user.setRole("USER");
            this.userService.addUser(user);
            return "new user created";
        }else{
            return "user not created";
        }
    }

}
