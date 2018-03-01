package ru.senla.bialevich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.senla.bialevich.entity.User;
import ru.senla.bialevich.service.api.IUserService;
import ru.senla.bialevich.service.TokenHandler;

import javax.servlet.http.HttpServletResponse;

@Controller
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"api/profile"}, method = {RequestMethod.GET})
    @ResponseBody
    public User getUser(@RequestHeader String token, HttpServletResponse response) {

        Integer id = TokenHandler.getInstance().extractAuthId(token);

        if (id != null) {
            return userService.getUserByLoginId(id);
        } else {
            response.setStatus(404);
            return null;
        }
    }
}