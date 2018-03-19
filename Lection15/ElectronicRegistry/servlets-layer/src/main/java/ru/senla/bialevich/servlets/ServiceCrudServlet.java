package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;

@WebServlet("/serviceCrud")
public class ServiceCrudServlet extends AbstractServlet {
    private static final long serialVersionUID = -142389170098236335L;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        String name = req.getParameter("name");
        String section = req.getParameter("section");
        Double price = Double.parseDouble(req.getParameter("surname"));
        Date startDate = Date.from(Instant.parse(req.getParameter("yyyy-MM-dd")));
        Date endDate = Date.from(Instant.parse(req.getParameter("yyyy-MM-dd")));

        Service service = new Service(name, price, section, startDate, endDate);

        hotel.addService(service);

        writer.println("Adding a service is successful.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        String section = req.getParameter("section");
        Date startDate = Date.from(Instant.parse(req.getParameter("yyyy-MM-dd")));
        Date endDate = Date.from(Instant.parse(req.getParameter("yyyy-MM-dd")));

        Service service = hotel.getService(id);

        if ((!req.getParameter(name).equals("")) || (req.getParameter(name) != null)) {
            service.setName(name);
        }
        if ((!req.getParameter(price.toString()).equals("")) || (req.getParameter(price.toString()) != null)) {
            service.setPrice(price);
        }
        if ((!req.getParameter(section).equals("")) || (req.getParameter(section) != null)) {
            service.setSection(section);
        }
        if ((!req.getParameter(startDate.toString()).equals("")) || (req.getParameter(endDate.toString()) != null)) {
            service.setStarDate(startDate);
        }
        if ((!req.getParameter(endDate.toString()).equals("")) || (req.getParameter(endDate.toString()) != null)) {
            service.setFinalDate(endDate);
        }

        writer.println("Update service is successful.");
    }
}
