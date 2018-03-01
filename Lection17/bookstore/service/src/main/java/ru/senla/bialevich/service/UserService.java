package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IUserService;

@Service("userService")
@Transactional
public class UserService implements IUserService {
}
