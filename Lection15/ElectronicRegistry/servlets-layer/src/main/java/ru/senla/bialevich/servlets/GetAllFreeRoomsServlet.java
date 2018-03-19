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

@WebServlet("/allFreeRooms")
public class GetAllFreeRoomsServlet extends AbstractServlet {
    private static final long serialVersionUID = -5201877359212690529L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        resp.setContentType(JSON);
        PrintWriter writer = resp.getWriter();

        List<Room> rooms = hotel.getAllFreeRooms();

        writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rooms));
    }
}
