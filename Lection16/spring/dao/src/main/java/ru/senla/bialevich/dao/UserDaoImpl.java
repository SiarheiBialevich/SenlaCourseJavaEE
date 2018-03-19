package ru.senla.bialevich.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IUserDao;
import ru.senla.bialevich.entity.Auth;
import ru.senla.bialevich.entity.User;

@Repository("userDaoImpl")
public class UserDaoImpl extends AbstractDaoImpl<User> implements IUserDao {

    public UserDaoImpl() {
        setClazz(User.class);
    }

    public User getUserByLoginAndPass(Auth auth) {

        Criteria criteria = getSession().createCriteria(User.class, "user");
        criteria.createCriteria("user.auth", "auth");
        criteria.add(Restrictions.eq("user.id",auth.getDetailFk()));

        return (User) criteria.uniqueResult();
    }
}
