package net.medrag.hiberapp.model.dao;

import net.medrag.hiberapp.model.domain.Role;
import net.medrag.hiberapp.model.domain.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.load(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email=:email");
        query.setParameter("email", email);
        return (User)query.uniqueResult();
    }

    @Override
    public User getUserByName(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username=:username");
        query.setParameter("username", username);
        return (User)query.uniqueResult();
    }

    @Override
    public User getUserByNameAndPass(String username, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username=:username and  password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User)query.uniqueResult();
    }

    @Override
    public void setRole(String username, Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username=:username");
        query.setParameter("username", username);
        User user = (User)query.uniqueResult();
        user.setRole(role);
        session.update(user);
        System.out.printf("User %s now has rights of %s", username, role);
    }

    @Override
    public List<User> getUserList() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("from User").list();
    }
}
