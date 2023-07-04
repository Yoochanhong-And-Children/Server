package com.example.hackathon.domain.user.repository;

import com.example.hackathon.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

<<<<<<< Updated upstream
=======
import javax.swing.text.html.Option;
>>>>>>> Stashed changes
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByPhoneNumber(String phoneNumber);
}
