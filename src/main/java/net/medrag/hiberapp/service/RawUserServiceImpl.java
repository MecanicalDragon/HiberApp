package net.medrag.hiberapp.service;

import net.medrag.hiberapp.dao.api.RawUserDao;
import net.medrag.hiberapp.model.RawUser;
import net.medrag.hiberapp.service.api.RawUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RawUserServiceImpl implements RawUserService {

    private RawUserDao rawUserDao;

    @Autowired
    public void setRawUserDao(RawUserDao rawUserDao) {
        this.rawUserDao = rawUserDao;
    }

    @Override
    @Transactional
    public String addUser(RawUser user) {
        return rawUserDao.addUser(user);
    }

    @Override
    public RawUser getUserByCode(String code) {
        return rawUserDao.getUserByCode(code);
    }

    @Override
    @Transactional
    public void removeUser(RawUser user) {
        rawUserDao.removeUser(user);
    }

    @Override
    public List<RawUser> getRawUsersList() {
        return rawUserDao.getRawUsersList();
    }

}