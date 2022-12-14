package com.metro.metromilan.repository;

import com.metro.metromilan.entity.UserClassRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<UserClassRegistration, UUID> {

    @Query(value = "SELECT * FROM user_registration u WHERE u.location=:p ORDER BY u.created_at DESC  LIMIT 2", nativeQuery = true)
    //@Query(value = "SELECT u FROM UserClassRegistration u WHERE u.place=:p")
    List<UserClassRegistration> getUserClassRegistrationByPlace(@Param("p") String place);

    UserClassRegistration findByName(String name);
}
