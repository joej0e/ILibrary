package spring.dao;

import spring.entity.Book;
import spring.entity.User;

import java.util.List;

public interface BookDao {
    Book add(Book book);

    List<Book> listBooks();

    void update(Book book);

    Book get(Long id);

    List<Book> findBooksByTitle(String title);

}

