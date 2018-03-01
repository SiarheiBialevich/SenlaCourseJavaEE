package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IUserDao;
import ru.senla.bialevich.entity.User;

@Repository("userDaoImpl")
public class UserDaoImpl extends AbstractDaoImpl<User> implements IUserDao {
}
