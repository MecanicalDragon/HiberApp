package net.medrag.hiberapp.model.service;

import net.medrag.hiberapp.model.dao.UserDao;
import net.medrag.hiberapp.model.domain.Role;
import net.medrag.hiberapp.model.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);

    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        return this.userDao.getUserByEmail(email);
    }

    @Override
    @Transactional
    public User getUserByName(String username) {
        return this.userDao.getUserByName(username);
    }

    @Override
    @Transactional
    public User getUserByNameAndPass(String username, String password) {
        return this.userDao.getUserByNameAndPass(username, password);
    }

    @Override
    public void setRole(String username, Role role) {
        this.userDao.setRole(username, role);
    }

    @Override
    @Transactional
    public List<User> getUserList() {
        return this.userDao.getUserList();
    }
}
