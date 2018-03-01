package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IGenreService;

@Service("genreService")
@Transactional
public class GenreService implements IGenreService {
}
