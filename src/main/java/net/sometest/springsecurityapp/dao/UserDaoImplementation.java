package net.sometest.springsecurityapp.dao;

import net.sometest.springsecurityapp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class UserDaoImplementation implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User findByUserName(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("from User where username=:name", User.class);
            query.setParameter("name",username);
            User user = (User)query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
