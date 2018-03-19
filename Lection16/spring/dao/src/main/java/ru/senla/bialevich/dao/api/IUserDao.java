package ru.senla.bialevich.dao.api;

import ru.senla.bialevich.entity.Auth;
import ru.senla.bialevich.entity.User;

public interface IUserDao extends IAbstractDao<User> {

    User getUserByLoginAndPass(Auth auth);
}
