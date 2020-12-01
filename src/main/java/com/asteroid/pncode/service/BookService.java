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
    BookDao bookDao;

    @Autowired
    CategoryService categoryService;

    public List<Book> list() {
        return bookDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }

    public List<Book> Search(String keywords) {
        return bookDao.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }

}
