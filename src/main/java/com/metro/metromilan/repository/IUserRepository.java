package com.metro.metromilan.repository;

import com.metro.metromilan.entity.UserClassRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<UserClassRegistration, UUID> {

}
