package com.metro.metromilan.services.Impl;

import com.metro.metromilan.entity.UserClassRegistration;
import com.metro.metromilan.repository.IUserRepository;
import com.metro.metromilan.services.Interfaces.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements IuserService {

    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public UserClassRegistration saveUser(UserClassRegistration userClassRegistration) {
        return iUserRepository.save(userClassRegistration);
    }

    @Override
    public List<UserClassRegistration> getAllUsersList() {
        return iUserRepository.findAll();
    }

    @Override
    public UserClassRegistration findbyName(String name) {
        return iUserRepository.findByName(name);
    }
}
