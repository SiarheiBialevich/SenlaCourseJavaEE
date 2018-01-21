package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/roomCrud")
public class RoomCrudServlet extends AbstractServlet {
    private static final long serialVersionUID = -1430024227225468968L;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Double price = Double.parseDouble(req.getParameter("price"));
        Integer capacity = Integer.parseInt(req.getParameter("capacity"));
        String section = req.getParameter("section");
        Integer rating = Integer.parseInt(req.getParameter("rating"));

        Room room = new Room(price, capacity, section, rating);

        hotel.addRoom(room);

        writer.println("Adding a guest is successful.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Integer id = Integer.parseInt(req.getParameter("id"));
        Double price = Double.parseDouble(req.getParameter("price"));
        Integer capacity = Integer.parseInt(req.getParameter("capacity"));
        String section = req.getParameter("section");
        Integer rating = Integer.parseInt(req.getParameter("rating"));

        Room room = hotel.getRoom(id);

        if ((!req.getParameter(price.toString()).equals("")) || (req.getParameter(price.toString()) != null)) {
            room.setPrice(price);
        }
        if ((!req.getParameter(capacity.toString()).equals("")) || (req.getParameter(capacity.toString()) != null)) {
            room.setCapacity(capacity);
        }
        if ((!req.getParameter(section).equals("")) || (req.getParameter(section) != null)) {
            room.setSection(section);
        }
        if ((!req.getParameter(rating.toString()).equals("")) || (req.getParameter(rating.toString()) != null)) {
            room.setRating(rating);
        }

        writer.println("Update room is successful.");
    }
}
