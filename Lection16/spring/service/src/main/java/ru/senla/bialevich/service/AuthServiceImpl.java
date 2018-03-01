package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.dao.api.IAuthDao;
import ru.senla.bialevich.entity.Auth;
import ru.senla.bialevich.service.api.IAuthService;

import java.sql.SQLException;

@Service("authServiceImpl")
@Transactional
public class AuthServiceImpl implements IAuthService {

    private final static Logger LOG = Logger.getLogger(AuthServiceImpl.class);

    @Autowired
    private IAuthDao authDao;

    @Override
    public void add(Auth auth) {

        try {

            authDao.add(auth);

        } catch (SQLException e) {

            LOG.error(e.getMessage());
        }
    }

    @Override
    public void update(Auth auth) {
        try {

            authDao.update(auth);

        } catch (SQLException e) {

            LOG.error(e.getMessage());
        }
    }

    @Override
    public Auth getAuthIdByLoginPass(String login, String password) {
        return authDao.getAuthByLoginPass(login, password);
    }

    @Override
    public Integer getAuthId(String login, String password) {
        return authDao.getAuthId(login, password);
    }
}
