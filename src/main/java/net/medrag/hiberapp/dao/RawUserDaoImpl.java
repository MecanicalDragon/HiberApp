package net.medrag.hiberapp.dao;

import net.medrag.hiberapp.dao.api.RawUserDao;
import net.medrag.hiberapp.model.RawUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class RawUserDaoImpl implements RawUserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String addUser(RawUser user) {
        String confirmCode;
        Long random1, random2, random3;
        do {
            random1 = new Random().nextLong();
            random2 = new Random().nextLong();
            random3 = new Random().nextLong();
            confirmCode = "unqcc" + random1.toString() + random2.toString() + random3.toString();
        } while (getUserByCode(confirmCode) != null);

        Session session = this.sessionFactory.getCurrentSession();
        user.setConfirmCode(confirmCode);
        session.persist(user);
        return confirmCode;
    }

    @Override
    public RawUser getUserByCode(String confirm_code) {
        try (Session session = this.sessionFactory.openSession()) {
            Query query = session.createQuery("from RawUser where confirm_code=:confirm_code");
            query.setParameter("confirm_code", confirm_code);
            return (RawUser) query.uniqueResult();
        }
    }

    @Override
    public void removeUser(RawUser user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RawUser> getRawUsersList() {
        try (Session session = this.sessionFactory.openSession()) {
            return (List<RawUser>) session.createQuery("from RawUser").list();
        }
    }
}
