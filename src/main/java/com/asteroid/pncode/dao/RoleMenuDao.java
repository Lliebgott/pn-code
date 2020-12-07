package com.asteroid.pncode.dao;

import com.asteroid.pncode.pojo.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author YuSai
 */
public interface RoleMenuDao extends JpaRepository<RoleMenu,Integer> {

    List<RoleMenu> findAllByRid(int rid);

    List<RoleMenu> findAllByRidIn(List<Integer> rids);

    void deleteAllByRid(int rid);
}
