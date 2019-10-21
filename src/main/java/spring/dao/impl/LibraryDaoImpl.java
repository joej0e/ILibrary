package spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.dao.LibraryDao;
import spring.entity.Author;
import spring.entity.Book;
import spring.entity.User;

import javax.persistence.Query;
import java.util.List;

@Repository
public class LibraryDaoImpl implements LibraryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Book> getBooksRentByUser(User user) {
        Query queryGetBooks = sessionFactory.createEntityManager()
                .createNativeQuery("select library.books.book_id," +
                " books.title, books.year, books.price, books.quantity from books" +
                " inner join rents on rents.book_id = books.book_id " +
                " where user_id = " + user.getId(), Book.class);
        return queryGetBooks.getResultList();
    }

    @Override
    public void returnBook(User user, Book book) {
        Integer quantity = book.getQuantity();
        user.getBooks().remove(book);
        book.setQuantity(quantity + 1);
        sessionFactory.getCurrentSession().update(book);
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void rentBook(User user, Book book) {
        Integer quantity = book.getQuantity();
        if(quantity > 0) {
            if (!user.getBooks().contains(book)) {
                user.getBooks().add(book);
                book.setQuantity(quantity - 1);
                sessionFactory.getCurrentSession().update(book);
                sessionFactory.getCurrentSession().update(user);
            }
        }
    }

    @Override
    public List<Book> findBooksByAuthor(String name, String surname) {
        Query queryGetBooks = sessionFactory.createEntityManager()
                .createNativeQuery("select library.books.book_id," +
                " books.title, books.year, books.price, books.quantity from books" +
                " inner join author_book on books.book_id = author_book.book_id inner join" +
                " authors on author_book.author_id = authors.author_id where" +
                        " name like ? and surname like ? ", Book.class);
        queryGetBooks.setParameter(1, name + "%");
        queryGetBooks.setParameter(2, surname + "%");
        return queryGetBooks.getResultList();
    }

    @Override
    public List<Book> findBooksByAuthor(String surname) {
        Query queryGetBooks = sessionFactory.createEntityManager().createNativeQuery("select library.books.book_id," +
                " books.title, books.year, books.price, books.quantity from books" +
                " inner join author_book on books.book_id = author_book.book_id inner join" +
                " authors on author_book.author_id = authors.author_id where" +
                " surname like ?", Book.class);
        queryGetBooks.setParameter(1, surname + "%");
        return queryGetBooks.getResultList();
    }

    @Override
    public void setBookAuthor(Book book, Author author) {
        book.getAuthors().add(author);
        sessionFactory.getCurrentSession().update(book);
    }
}
