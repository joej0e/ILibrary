/*
package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.LibraryDao;
import spring.entity.Author;
import spring.entity.Book;
import spring.entity.User;
import spring.service.LibraryService;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Transactional
    @Override
    public void setBookAuthor(Book book, Author author) {
        libraryDao.setBookAuthor(book, author);
    }

    @Transactional
    @Override
    public List<Book> findBooksByAuthor(String surname) {
        return libraryDao.findBooksByAuthor(surname);
    }

    @Transactional
    @Override
    public List<Book> findBooksByAuthor(String name, String surname) {
        return libraryDao.findBooksByAuthor(name, surname);
    }

    @Autowired
    private LibraryDao libraryDao;

    @Transactional
    @Override
    public void rentBook(User user, Book book) {
       libraryDao.rentBook(user, book);
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        libraryDao.returnBook(user, book);
    }

    @Transactional
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return libraryDao.getBooksRentByUser(user);
    }
}


 */
