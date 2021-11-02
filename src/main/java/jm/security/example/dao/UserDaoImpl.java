package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u");
        return query.getResultList();
    }

}

