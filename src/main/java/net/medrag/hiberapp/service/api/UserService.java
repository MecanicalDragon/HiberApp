package net.medrag.hiberapp.service.api;

import net.medrag.hiberapp.model.Role;
import net.medrag.hiberapp.model.User;
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
