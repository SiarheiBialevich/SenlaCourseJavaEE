package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IAuthDao;
import ru.senla.bialevich.entity.Auth;

@Repository("authDaoImpl")
public class AuthDaoImpl extends AbstractDaoImpl<Auth> implements IAuthDao {
}
