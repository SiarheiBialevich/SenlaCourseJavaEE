package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/crudGuest")
public class GuestCrudServlet extends AbstractServlet {
    private static final long serialVersionUID = 5056436663542896374L;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        Guest guest = new Guest(name, surname);

        hotel.addGuest(guest);

        writer.println("Adding a guest is successful.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        Guest guest = hotel.getGuest(id);

        if ((!req.getParameter(name).equals("")) || (req.getParameter(name) != null)) {
            guest.setName(name);
        }

        if ((!req.getParameter(surname).equals("")) || (req.getParameter(surname) != null)) {
            guest.setSurname(surname);
        }

        writer.println("Update guest is successful.");
    }
}
