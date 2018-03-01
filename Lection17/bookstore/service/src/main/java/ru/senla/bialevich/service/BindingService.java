package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IBindingService;

@Service("bindingService")
@Transactional
public class BindingService implements IBindingService {
}
