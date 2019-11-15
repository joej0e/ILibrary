package spring.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.entity.Author;
import spring.entity.Book;
import spring.entity.User;

import java.util.List;

@Repository
public interface LibraryDao {

    @Query(
            value = "select library.books.book_id," +
                    " books.title, books.year, books.price, books.quantity from books" +
                    " inner join rents on rents.book_id = books.book_id " +
                    " where user_id = ?1", nativeQuery = true)
    List<Book> getBooksRentByUser(User user);

    void returnBook(User user, Book book);

    void rentBook(User user, Book book);

    void setBookAuthor(Book book, Author author);

    @Query(
            value = "select * from library.books" +
                    " inner join author_book on books.book_id = author_book.book_id inner join" +
                    " authors on author_book.author_id = authors.author_id where" +
                    " surname like 1?", nativeQuery = true
    )
    List<Book> findBooksByAuthor(String surname);

    @Query(
            value = "select * from library.books" +
                    " inner join author_book on books.book_id = author_book.book_id inner join" +
                    " authors on author_book.author_id = authors.author_id where" +
                    " name like ? and surname like ?", nativeQuery = true
    )
    List<Book> findBooksByAuthor(String name, String surname);
}
