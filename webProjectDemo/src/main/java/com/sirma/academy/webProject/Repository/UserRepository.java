package com.sirma.academy.webProject.Repository;

import com.sirma.academy.webProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //List<User> getUserByName(User user);
    @Query("SELECT u FROM User u WHERE u.name = :name")
    Optional<User> getUserByName(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> getUsersByEmail(@Param("email") String email);
}
