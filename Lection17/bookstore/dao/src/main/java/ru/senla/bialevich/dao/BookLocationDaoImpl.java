package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IBookLokationDao;
import ru.senla.bialevich.entity.BookLocation;

@Repository("bookLocationDaoImpl")
public class BookLocationDaoImpl extends AbstractDaoImpl<BookLocation> implements IBookLokationDao {
}
