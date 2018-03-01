package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IAddressService;

@Service("addressService")
@Transactional
public class AddressService implements IAddressService {
}
