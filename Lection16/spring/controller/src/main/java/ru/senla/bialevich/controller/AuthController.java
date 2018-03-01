package ru.senla.bialevich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.senla.bialevich.service.TokenHandler;
import ru.senla.bialevich.service.api.IAuthService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RestController
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
    public void auth(@RequestHeader String login, @RequestHeader String pass, HttpServletResponse response) {

        Integer id = authService.getAuthId(login, pass);

        if (authService != null) {
            String token = TokenHandler.getInstance().generateAccessToken(id);
            response.addHeader("X-Auth-Token", token);
        } else {
            response.setStatus(401);
        }
    }
}