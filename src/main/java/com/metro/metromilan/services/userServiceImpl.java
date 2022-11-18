package com.metro.metromilan.services;

import com.metro.metromilan.entity.UserClassRegistration;
import com.metro.metromilan.repository.IUserRepository;
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
}
