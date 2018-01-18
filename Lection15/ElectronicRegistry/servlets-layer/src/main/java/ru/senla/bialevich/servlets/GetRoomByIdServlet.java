package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getRoom")
public class GetRoomByIdServlet extends AbstractServlet {
    private static final long serialVersionUID = -8501408391237837578L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        resp.setContentType(JSON);

        PrintWriter writer = resp.getWriter();

        Integer id = Integer.parseInt(req.getParameter("id"));

        Room room = hotel.getRoom(id);

        writer.write(mapper.writeValueAsString(room));
    }
}
