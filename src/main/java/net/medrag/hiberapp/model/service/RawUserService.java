package net.medrag.hiberapp.model.service;

import net.medrag.hiberapp.model.domain.RawUser;

import java.util.List;

public interface RawUserService {

    String addUser(RawUser user);
    RawUser getUserByCode(String code);
    void removeUser(RawUser user);
    List<RawUser> getRawUsersList();

}
