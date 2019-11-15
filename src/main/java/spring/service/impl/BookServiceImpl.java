package spring.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.BookRepository;
import spring.entity.Book;
import spring.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book get(Long id) {
        return bookRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }
}

