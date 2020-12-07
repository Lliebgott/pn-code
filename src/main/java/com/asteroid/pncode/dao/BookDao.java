package com.asteroid.pncode.dao;

import com.asteroid.pncode.pojo.Book;
import com.asteroid.pncode.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author YuSai
 */

public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);

}
