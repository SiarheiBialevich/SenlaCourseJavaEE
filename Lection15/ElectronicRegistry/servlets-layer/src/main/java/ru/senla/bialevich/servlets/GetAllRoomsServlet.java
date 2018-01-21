package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/allRooms")
public class GetAllRoomsServlet extends AbstractServlet {
    private static final long serialVersionUID = 5335416693092046179L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        resp.setContentType(JSON);
        PrintWriter writer = resp.getWriter();

        List<Room> rooms = hotel.getAllRooms(null);

        writer.write(mapper.writeValueAsString(rooms));
    }

}
