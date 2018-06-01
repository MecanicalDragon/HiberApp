package net.medrag.hiberapp.model.service;

import net.medrag.hiberapp.model.domain.Role;
import net.medrag.hiberapp.model.domain.User;
import java.util.List;

public interface UserService {

    void addUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getUserByName(String username);
    User getUserByNameAndPass(String username, String password);
    void setRole(String username, Role role);
    List<User> getUserList();
}
