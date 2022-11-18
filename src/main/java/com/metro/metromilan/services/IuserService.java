package com.metro.metromilan.services;

import com.metro.metromilan.entity.UserClassRegistration;

import java.util.List;

public interface IuserService {
    UserClassRegistration saveUser(UserClassRegistration userClassRegistration);

    List<UserClassRegistration> getAllUsersList();
}
