package ru.senla.bialevich.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cloneRoom")
public class RoomCloneServlet extends AbstractServlet {
    private static final long serialVersionUID = 8826867542908969683L;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Integer id = Integer.parseInt(req.getParameter("id"));

        hotel.cloneRoom(id);

        writer.println("Clone room is successful.");
    }
}
