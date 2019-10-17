package spring.service;

import spring.entity.Book;

import java.util.List;

public interface BookService {
    void add(Book book);

    List<Book> listBooks();
}

