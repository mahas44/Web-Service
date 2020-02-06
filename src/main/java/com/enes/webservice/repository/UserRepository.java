package com.enes.webservice.repository;

import com.enes.webservice.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<AppUser, String> {
    Optional<AppUser> findByEmail(String email);
    AppUser findByUsername(String username);

    Optional<AppUser> findByUsernameOrPassword(String username, String password);

    boolean existsAppUserByUsername(String username);

    boolean existsAppUserByEmail(String email);

    int countAppUserByUsername(String username);
}
