package ru.senla.bialevich.servlets;

import ru.senla.bialevich.controller.ControllerHotel;
import ru.senla.bialevich.dependency.DependencyInjection;

import javax.servlet.http.HttpServlet;

public abstract class AbstractServlet extends HttpServlet {
    private static final long serialVersionUID = -352995301122905805L;

    protected static ControllerHotel hotel = (ControllerHotel) DependencyInjection.getInjection().getInstance(ControllerHotel.class);

    protected static final String JSON = "application/json;charset=utf-8";

}
