package spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.dao.UserDao;
import spring.entity.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        Long id = (Long)  sessionFactory.getCurrentSession().save(user);
        user.setId(id);
        return user;
    }

    @Override
    public List<User> listUsers() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}

