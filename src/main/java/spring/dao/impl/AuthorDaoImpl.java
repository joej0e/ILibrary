package spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.dao.AuthorDao;
import spring.entity.Author;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Author add(Author author) {
        Long id = (Long) sessionFactory.getCurrentSession().save(author);
        author.setAuthorId(id);
        return author;
    }

    @Override
    public List<Author> listAuthors() {
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("from Author", Author.class);
        return query.getResultList();
    }
}
