package net.medrag.hiberapp.service.api;

import net.medrag.hiberapp.model.RawUser;

import java.util.List;

public interface RawUserService {

    String addUser(RawUser user);
    RawUser getUserByCode(String code);
    void removeUser(RawUser user);
    List<RawUser> getRawUsersList();

}
