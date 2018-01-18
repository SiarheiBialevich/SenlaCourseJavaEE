package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getRegistration")
public class GetRegistrationByIdServlet extends AbstractServlet {
    private static final long serialVersionUID = -5117409596189444390L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Integer id = Integer.parseInt(req.getParameter("id"));

        Registration registration = hotel.getRegistration(id);

        writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(registration));
    }
}
