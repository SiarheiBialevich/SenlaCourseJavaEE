package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getService")
public class GetServiceByIdServlet extends AbstractServlet {
    private static final long serialVersionUID = 3513346294676043360L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter printWriter = resp.getWriter();

        resp.setContentType(JSON);

        Integer id = Integer.parseInt(req.getParameter("id"));

        Service service = hotel.getService(id);

        printWriter.write(mapper.writeValueAsString(service));
    }
}
