package ru.senla.bialevich.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IAuthDao;
import ru.senla.bialevich.entity.Auth;

@Repository("authDaoImpl")
public class AuthDaoImpl extends AbstractDaoImpl<Auth> implements IAuthDao {

    public AuthDaoImpl() {
        setClazz(Auth.class);
    }

    @Override
    public Auth getAuthByLoginPass(String login, String password) {

        Criteria criteria = getSession().createCriteria(Auth.class);
        Criterion l = Restrictions.eq("login", login);
        Criterion p = Restrictions.eq("password", password);
        LogicalExpression orExp = Restrictions.and(l, p);
        criteria.add(orExp);

        Auth auth = (Auth) criteria.uniqueResult();

        return auth;
    }

    @Override
    public Integer getAuthId(String login, String password) {

        Criteria criteria = getSession().createCriteria(Auth.class);
        Criterion l = Restrictions.eq("login", login);
        Criterion p = Restrictions.eq("password", password);
        LogicalExpression orExp = Restrictions.and(l, p);
        criteria.add(orExp);

        Auth auth = (Auth) criteria.uniqueResult();

        return auth.getId();
    }
}
