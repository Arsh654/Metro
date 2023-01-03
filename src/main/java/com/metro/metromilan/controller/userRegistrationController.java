package com.metro.metromilan.controller;

import com.metro.metromilan.entity.UserClassRegistration;
import com.metro.metromilan.exception.errorSchema;
import com.metro.metromilan.exception.userNotFoundException;
import com.metro.metromilan.services.Interfaces.IuserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userRegistrationController {

    private final IuserService iuserService;

    private static final Logger LOGGER = LoggerFactory.getLogger(userRegistrationController.class);

    public userRegistrationController(IuserService iuserService) {
        this.iuserService = iuserService;
    }


    @PostMapping("/user")
    private UserClassRegistration saveUserAllData(@Valid @RequestBody UserClassRegistration userClassRegistration ){
        LOGGER.info("Inside the User Registration Controller Class");
        System.out.println("The Custom Object value is : " + userClassRegistration);
        return iuserService.saveUser(userClassRegistration);
    }

    @GetMapping("/user")
    private List<UserClassRegistration> getAllUsersList(){
        LOGGER.info("Inside the getAllUsers Controller And fetching all the user data");

        List<UserClassRegistration> allUsers = iuserService.getAllUsersList();

//        if(allUsers.isEmpty()){
//            //throw some custom error..
//            throw new userNotFoundException("User Not Found");
//
//        }
//        //List<UserClassRegistration>


        return allUsers;
    }

    /*
    API to get the Response based on the users name.
    Params
     1. @String Name
    */
    @GetMapping("/user/{name}")
    private UserClassRegistration getUserByName(@PathVariable String name){
        UserClassRegistration user = iuserService.findbyName(name);
        if(user == null){
            throw new userNotFoundException("User with name " + name + " not found");
        }

        return user;
    }
}
