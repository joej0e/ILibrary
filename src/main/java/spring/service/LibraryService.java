package spring.service;

import spring.entity.Author;
import spring.entity.Book;
import spring.entity.Rent;
import spring.entity.User;

import java.util.List;

public interface LibraryService {

    void rentBook(User user, Book book);

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);

    void setBookAuthor(Book book, Author author);

    List<Book> findBooksByAuthor(String surname);

    List<Book> findBooksByAuthor(String name, String surname);
}


