package com.asteroid.pncode.dao;

import com.asteroid.pncode.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author YuSai
 */
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}
