package com.academy.sirma.restdbapp.Repository;

import com.academy.sirma.restdbapp.Model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void register(User user){
        String sql = "INSERT INTO users(username, password,email) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(),user.getPassword(),user.getEmail());
    }


    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }
}
