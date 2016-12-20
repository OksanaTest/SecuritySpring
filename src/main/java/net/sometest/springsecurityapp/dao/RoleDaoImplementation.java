package net.sometest.springsecurityapp.dao;

import net.sometest.springsecurityapp.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImplementation implements RoleDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getRole(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = session.load(Role.class, id);
        return role;
    }
}
