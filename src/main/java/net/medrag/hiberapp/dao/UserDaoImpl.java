package net.medrag.hiberapp.dao;

import net.medrag.hiberapp.dao.api.UserDao;
import net.medrag.hiberapp.model.Role;
import net.medrag.hiberapp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        try (Session session = this.sessionFactory.openSession()) {
            return session.load(User.class, id);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try (Session session = this.sessionFactory.openSession()) {
            Query query = session.createQuery("from User where email=:email");
            query.setParameter("email", email);
            return (User) query.uniqueResult();
        }
    }

    @Override
    public User getUserByName(String username) {
        try (Session session = this.sessionFactory.openSession()) {
            Query query = session.createQuery("from User where username=:username");
            query.setParameter("username", username);
            return (User) query.uniqueResult();
        }
    }

    @Override
    public User getUserByNameAndPass(String username, String password) {
        try (Session session = this.sessionFactory.openSession()) {
            Query query = session.createQuery("from User where username=:username and  password=:password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (User) query.uniqueResult();
        }
    }

    @Override
    public void setRole(String username, Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username=:username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        user.setRole(role);
        session.update(user);
        System.out.printf("User %s now has rights of %s", username, role);
    }

    @Override
    public List<User> getUserList() {
        try (Session session = this.sessionFactory.openSession()) {
            return (List<User>) session.createQuery("from User").list();
        }
    }
}
