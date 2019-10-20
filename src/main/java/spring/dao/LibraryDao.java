package spring.dao;

import spring.entity.Author;
import spring.entity.Book;
import spring.entity.User;

import java.util.List;

public interface LibraryDao {

    List<Book> getBooksRentByUser(User user);

    void returnBook(User user, Book book);

    void rentBook(User user, Book book);

    void setBookAuthor(Book book, Author author);

    List<Book> findBooksByAuthor(String surname);

    List<Book> findBooksByAuthor(String name, String surname);
}


