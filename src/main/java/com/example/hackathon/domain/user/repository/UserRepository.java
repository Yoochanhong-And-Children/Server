package com.example.hackathon.domain.user.repository;

import com.example.hackathon.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByName(String phoneNumber);
}
