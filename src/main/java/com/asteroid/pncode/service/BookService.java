package com.asteroid.pncode.service;

import com.asteroid.pncode.dao.BookDao;
import com.asteroid.pncode.pojo.Book;
import com.asteroid.pncode.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author YuSai
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDAO;

    @Autowired
    CategoryService categoryService;

    public List<Book> list() {
        return bookDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }

    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }
}
