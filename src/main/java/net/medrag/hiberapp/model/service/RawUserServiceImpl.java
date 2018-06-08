package net.medrag.hiberapp.model.service;

import net.medrag.hiberapp.model.dao.RawUserDao;
import net.medrag.hiberapp.model.domain.RawUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    @Transactional
    public RawUser getUserByCode(String code) {
        return rawUserDao.getUserByCode(code);
    }

    @Override
    @Transactional
    public void removeUser(RawUser user) {
        rawUserDao.removeUser(user);
    }

    @Override
    @Transactional
    public List<RawUser> getRawUsersList() {
        return rawUserDao.getRawUsersList();
    }

}