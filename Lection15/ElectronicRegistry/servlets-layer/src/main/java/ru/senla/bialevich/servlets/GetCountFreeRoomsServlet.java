package ru.senla.bialevich.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/countFreeRooms")
public class GetCountFreeRoomsServlet extends AbstractServlet {
    private static final long serialVersionUID = 210603787365152029L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Integer count = hotel.getCountFreeRooms();

        writer.println("Count free rooms - " + count);
    }
}
