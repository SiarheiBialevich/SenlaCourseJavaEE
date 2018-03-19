package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/allGuests")
public class GetAllGuestsServlet extends AbstractServlet {
    private static final long serialVersionUID = 8346135604311140257L;
    private final static Logger LOG = Logger.getLogger(GetAllGuestsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        resp.setContentType(JSON);
        PrintWriter writer = resp.getWriter();

        List<Guest> guests = hotel.getAllGuests();

        writer.write(mapper.writeValueAsString(guests));
    }
}
