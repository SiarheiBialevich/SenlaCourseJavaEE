package ru.senla.bialevich.service.api;

import ru.senla.bialevich.entity.Auth;


public interface IAuthService {

    //create
    void add(Auth auth);

    //update
    void update(Auth auth);

    Auth getAuthIdByLoginPass(String login, String password);

    Integer getAuthId(String login, String password);

}
