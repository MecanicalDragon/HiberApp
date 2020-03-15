package net.medrag.hiberapp.dao.api;

import net.medrag.hiberapp.model.RawUser;
import java.util.List;

public interface RawUserDao {

    String addUser(RawUser user);
    RawUser getUserByCode(String confirm_code);
    void removeUser(RawUser user);
    List<RawUser> getRawUsersList();
}
