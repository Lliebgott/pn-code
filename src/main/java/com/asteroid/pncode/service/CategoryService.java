package com.asteroid.pncode.service;
import com.asteroid.pncode.dao.CategoryDao;
import com.asteroid.pncode.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YuSai
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public List<Category> list() {
        return categoryDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Category get(int id) {
        return categoryDao.findById(id).orElse(null);
    }
}
