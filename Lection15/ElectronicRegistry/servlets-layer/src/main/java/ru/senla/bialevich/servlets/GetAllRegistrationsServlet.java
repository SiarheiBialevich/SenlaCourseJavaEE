package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/allRegistrations")
public class GetAllRegistrationsServlet extends AbstractServlet {
    private static final long serialVersionUID = -4218673475107663370L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        mapper.setDateFormat(df);

        resp.setContentType(JSON);
        PrintWriter writer = resp.getWriter();

        List<Registration> registrations = hotel.getAllRegistrations();

        writer.write(mapper.writeValueAsString(registrations));
    }
}
