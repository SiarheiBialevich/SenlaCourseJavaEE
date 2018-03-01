package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IAuthService;

@Service("authService")
@Transactional
public class AuthService implements IAuthService {
}
