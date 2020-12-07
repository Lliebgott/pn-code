package com.asteroid.pncode.dao;

import com.asteroid.pncode.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author YuSai
 */
public interface UserRoleDao extends JpaRepository<UserRole,Integer> {

    List<UserRole> findAllByUid(int uid);

    void deleteAllByUid(int uid);

}
