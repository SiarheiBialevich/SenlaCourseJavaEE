package ru.senla.bialevich.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.senla.bialevich.service.api.IAuthService;
import ru.senla.bialevich.service.api.IUserService;

public class Test {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IAuthService authService = (IAuthService) context.getBean("authServiceImpl");
        IUserService userService = (IUserService) context.getBean("userServiceImpl");

//        User user = userService.getUserByLoginId(1);

//        Auth auth = authService.getAuthByLoginPass("albis", "12345");

        Integer id = authService.getAuthId("albis", "12345");

//        System.out.println(user.getName() + ", " + user.getSurname() + ", " + user.getEmail());

//        System.out.println(user.getName());

//        User user = null;

//            Integer id = userService.getUserIdByLoginAndPass("Ivan", "54321");

//        System.out.println(user.getName() + " " + user.getSurname() + " " + user.getEmail());

        System.out.println(id);

    }
}
