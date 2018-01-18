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
        ObjectMapper mapper = new ObjectMapper();

        StringBuffer sb = new StringBuffer();
        String query = null;
        BufferedReader reader = req.getReader();

        while ((query = reader.readLine()) != null) {
            sb.append(query);
        }

        Room room = mapper.readValue(sb.toString(), Room.class);

        PrintWriter writer = resp.getWriter();

        hotel.updateRoom(room);

        writer.println("Update room is successful.");
    }
}
