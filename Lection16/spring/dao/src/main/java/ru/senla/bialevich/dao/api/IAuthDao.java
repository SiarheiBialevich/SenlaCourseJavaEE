package ru.senla.bialevich.dao.api;

import ru.senla.bialevich.entity.Auth;

public interface IAuthDao extends IAbstractDao<Auth> {

    Auth getAuthByLoginPass(String login, String password);

    Integer getAuthId(String login, String password);
}
