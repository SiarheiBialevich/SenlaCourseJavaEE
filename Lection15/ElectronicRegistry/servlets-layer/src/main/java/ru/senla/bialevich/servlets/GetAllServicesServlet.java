package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.enums.ServicesSection;
import ru.senla.bialevich.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/allServices")
public class GetAllServicesServlet extends AbstractServlet {
    private static final long serialVersionUID = -4285759937157034741L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        resp.setContentType(JSON);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        mapper.setDateFormat(df);

        PrintWriter writer = resp.getWriter();

        List<Service> services = hotel.getAllServices();

        writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(services));

    }

}
