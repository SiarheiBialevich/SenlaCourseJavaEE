package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IBookService;

@Service("bookService")
@Transactional
public class BookService implements IBookService {
}
