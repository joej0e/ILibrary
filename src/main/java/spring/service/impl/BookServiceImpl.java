package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.BookDao;
import spring.entity.Book;
import spring.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public Book get(Long id) {
        return bookDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findBooksByTitle(title);
    }
}

