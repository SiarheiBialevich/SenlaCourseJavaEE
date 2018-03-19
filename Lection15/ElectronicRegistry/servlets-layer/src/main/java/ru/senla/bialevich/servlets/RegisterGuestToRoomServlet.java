package ru.senla.bialevich.servlets;

import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;

@WebServlet("/registerGuest")
public class RegisterGuestToRoomServlet extends AbstractServlet {
    private static final long serialVersionUID = 9180133885550461363L;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        Guest guest = new Guest(name, surname);

        hotel.addGuest(guest);

        Double price = Double.parseDouble(req.getParameter("price"));
        Integer capacity = Integer.parseInt(req.getParameter("capacity"));
        String section = req.getParameter("section");
        Integer rating = Integer.parseInt(req.getParameter("rating"));

        Room room = new Room(price, capacity, section, rating);

        hotel.addRoom(room);

        Date startDate = Date.from(Instant.parse(req.getParameter("yyyy-MM-dd")));
        Date endDate = Date.from(Instant.parse(req.getParameter("yyyy-MM-dd")));

        hotel.registerGuest(guest, room, startDate, endDate);

        writer.write("Registration guest is success.");
    }
}
