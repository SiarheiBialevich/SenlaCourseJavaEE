package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IBookLocationService;

@Service("bookLocationService")
@Transactional
public class BookLocationService implements IBookLocationService {
}
