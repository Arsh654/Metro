package com.metro.metromilan.services.Impl;

import com.metro.metromilan.controller.firstTimeController;
import com.metro.metromilan.entity.UserClassRegistration;
import com.metro.metromilan.repository.IUserRepository;
import com.metro.metromilan.services.Interfaces.IfirstTimeUserService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class firstTimeUserServiceImpl implements IfirstTimeUserService {

    //private final static Logger log = LoggerFactory.getLogger(firstTimeUserServiceImpl.class);
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(firstTimeUserServiceImpl.class);
    final IUserRepository iUserRepository;

    public firstTimeUserServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public List<UserClassRegistration> getNearbyDestination(String place) {
        //Query the DB -> Fetch the 10 results in accord with place
        log.info("Inside the service layer and in getNearbyDestination method");
        log.info("Preparing for the DB Call ----" + place);
        List<UserClassRegistration> ans = iUserRepository.getUserClassRegistrationByPlace(place);
        //return Optional.empty();
        return ans;
    }
}
