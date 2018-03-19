package ru.senla.bialevich.service.api;

import ru.senla.bialevich.entity.User;


public interface IUserService {

    //create
    void addUser(User user);

    //update
    void update(User user);

    User getUserById(Integer id);

    User getUserByLoginId(Integer id);

    User getUserByLoginAndPassword(String login, String pass);
}
