package spring.service;

import spring.entity.Book;

import java.util.List;

public interface BookService {
    Book add(Book book);

    List<Book> listBooks();

    List< Book> findByTitle(String title);

    Book get(Long id);

}

