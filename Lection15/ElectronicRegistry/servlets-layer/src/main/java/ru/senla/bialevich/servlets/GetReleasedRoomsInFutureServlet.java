package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@WebServlet("/roomInFuture")
public class GetReleasedRoomsInFutureServlet extends AbstractServlet {
    private static final long serialVersionUID = -5806016298041334809L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Date futureDate = Date.from(Instant.parse(req.getParameter("yyyy-MM-dd")));

        List<Room> rooms = hotel.getReleasedRoomsInFuture(futureDate);

        writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rooms));
    }
}
