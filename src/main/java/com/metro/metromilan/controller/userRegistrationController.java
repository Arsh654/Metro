package com.metro.metromilan.controller;

import com.metro.metromilan.entity.UserClassRegistration;
import com.metro.metromilan.services.IuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class userRegistrationController {

    private final IuserService iuserService;

    private static final Logger LOGGER = LoggerFactory.getLogger(userRegistrationController.class);

    public userRegistrationController(IuserService iuserService) {
        this.iuserService = iuserService;
    }


    @PostMapping("/users")
    private UserClassRegistration saveUserAllData(@Valid @RequestBody UserClassRegistration userClassRegistration ){
        LOGGER.info("Inside the User Registration Controller Class");
        System.out.println("The Custom Object value is : " + userClassRegistration);
        return iuserService.saveUser(userClassRegistration);
    }

    @GetMapping("/users")
    private List<UserClassRegistration> getAllUsersList(){
        LOGGER.info("Inside the getAllUsers Controller And fetching all the user data");
        return iuserService.getAllUsersList();
    }
}
