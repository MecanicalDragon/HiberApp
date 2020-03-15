package net.medrag.hiberapp.service;

import net.medrag.hiberapp.dao.api.UserDao;
import net.medrag.hiberapp.model.Role;
import net.medrag.hiberapp.model.User;
import net.medrag.hiberapp.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        this.userDao.addUser(user);

    }

    @Override
    public User getUserById(Long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userDao.getUserByEmail(email);
    }

    @Override
    public User getUserByName(String username) {
        return this.userDao.getUserByName(username);
    }

    @Override
    public User getUserByNameAndPass(String username, String password) {
        return this.userDao.getUserByNameAndPass(username, password);
    }

    @Override
    @Transactional
    public void setRole(String username, Role role) {
        this.userDao.setRole(username, role);
    }

    @Override
    public List<User> getUserList() {
        return this.userDao.getUserList();
    }
}
