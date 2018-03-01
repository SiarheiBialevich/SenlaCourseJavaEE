package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IBookDao;
import ru.senla.bialevich.entity.Book;

@Repository("bookDaoImpl")
public class BookDaoImpl extends AbstractDaoImpl<Book> implements IBookDao {
}
