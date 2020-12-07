package com.asteroid.pncode.dao;

import com.asteroid.pncode.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author YuSai
 */
public interface MenuDao extends JpaRepository<Menu, Integer> {

     Menu findById(int id);

     List<Menu> findAllByParentId(int parentId);

}

