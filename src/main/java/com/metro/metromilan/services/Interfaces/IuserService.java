package com.metro.metromilan.services.Interfaces;

import com.metro.metromilan.entity.UserClassRegistration;

import java.util.List;

public interface IuserService {
    UserClassRegistration saveUser(UserClassRegistration userClassRegistration);

    List<UserClassRegistration> getAllUsersList();

    UserClassRegistration findbyName(String name);
}
