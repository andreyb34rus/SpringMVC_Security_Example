package jm.security.example.dao;

import jm.security.example.model.Role;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public Role getRoleById(long id) {
        return sessionFactory.getCurrentSession().find(Role.class, id);
    }

    @Transactional
    @Override
    public Role getRoleByName(String name) {
         Query query = sessionFactory.getCurrentSession().createQuery("from Role r where r.role = :nameParam");
         query.setParameter("nameParam", name);
        return (Role) query.getSingleResult();
    }

    @Transactional
    @Override
    public List<Role> getAllRoles() {
        return sessionFactory.getCurrentSession().createQuery("from Role r").getResultList();
    }
}
