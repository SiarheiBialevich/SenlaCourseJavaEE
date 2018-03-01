package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IGenreDao;
import ru.senla.bialevich.entity.Genre;

@Repository("genreDaoImpl")
public class GenreDaoImpl extends AbstractDaoImpl<Genre> implements IGenreDao {
}
