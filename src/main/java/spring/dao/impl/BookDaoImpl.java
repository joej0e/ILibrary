package spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.BookDao;
import spring.entity.Book;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Book add(Book book) {
        Long id = (Long) sessionFactory.getCurrentSession().save(book);
        book.setId(id);
        return book;
    }

    @Transactional
    @Override
    public void update(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    @Override
    public Book get(Long id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        TypedQuery<Book> query = sessionFactory.createEntityManager().createQuery(
                "select b from Book b where b.title like ?1", Book.class);
        query.setParameter(1, title + "%");
        return query.getResultList();
    }

}
