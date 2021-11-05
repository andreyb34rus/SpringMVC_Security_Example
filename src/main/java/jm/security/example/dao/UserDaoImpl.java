package jm.security.example.dao;

import jm.security.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.name = :userNameParam");
        query.setParameter("userNameParam", name);
        return (User) query.getSingleResult();
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.find(User.class, id));
    }
}

