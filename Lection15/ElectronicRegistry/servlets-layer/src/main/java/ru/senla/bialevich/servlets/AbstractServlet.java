package ru.senla.bialevich.servlets;

import ru.senla.bialevich.controller.ControllerHotel;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.enums.SortType;

import javax.servlet.http.HttpServlet;

public abstract class AbstractServlet extends HttpServlet {
    private static final long serialVersionUID = -352995301122905805L;

    protected static ControllerHotel hotel = (ControllerHotel) DependencyInjection.getInjection().getInstance(ControllerHotel.class);

    protected static final String JSON = "application/json;charset=utf-8";

    protected SortType getSort(String query) {
        SortType type = null;
        for (SortType sortType : SortType.values()) {
            if (sortType.getSort().equals(query)) {
                type = sortType;
            }
        }
        return type;
    }

}
