package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.dao.api.IAuthDao;
import ru.senla.bialevich.dao.api.IUserDao;
import ru.senla.bialevich.entity.Auth;
import ru.senla.bialevich.entity.User;
import ru.senla.bialevich.service.api.IUserService;

import java.sql.SQLException;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements IUserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IAuthDao authDao;

    @Override
    public void addUser(User user) {

        try {

            userDao.add(user);

        } catch (SQLException e) {

            LOG.error(e.getMessage());
        }
    }

    @Override
    public void update(User user) {

        try {

            userDao.update(user);

        } catch (SQLException e) {

            LOG.error(e.getMessage());
        }
    }

    @Override
    public User getUserById(Integer id) {

        try {

            return userDao.getById(id);

        } catch (SQLException e) {

            LOG.error(e.getMessage());

            return null;
        }
    }

    public User getUserByLoginId(Integer id) {

        try {
            Auth auth = authDao.getById(id);
            return userDao.getUserByLoginAndPass(auth);

        } catch (SQLException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserByLoginAndPassword(String login, String pass) {

        Auth auth = authDao.getAuthByLoginPass(login, pass);

        return userDao.getUserByLoginAndPass(auth);
    }
}
