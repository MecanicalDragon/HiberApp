package net.medrag.hiberapp.model.dao;

import net.medrag.hiberapp.model.domain.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getUserByName(String username);
    User getUserByNameAndPass(String username, String password);
    List<User> getUserList();

}
