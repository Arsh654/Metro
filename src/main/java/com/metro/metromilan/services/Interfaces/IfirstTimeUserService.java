package com.metro.metromilan.services.Interfaces;

import com.metro.metromilan.entity.UserClassRegistration;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface IfirstTimeUserService {

    List<UserClassRegistration> getNearbyDestination(@NotNull String place);
}
