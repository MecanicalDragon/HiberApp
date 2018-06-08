package net.medrag.hiberapp.model.dao;

import net.medrag.hiberapp.model.domain.RawUser;
import java.util.List;

public interface RawUserDao {

    String addUser(RawUser user);
    RawUser getUserByCode(String confirm_code);
    void removeUser(RawUser user);
    List<RawUser> getRawUsersList();
}
