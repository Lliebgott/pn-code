package com.asteroid.pncode.dao;

import com.asteroid.pncode.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author YuSai
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
