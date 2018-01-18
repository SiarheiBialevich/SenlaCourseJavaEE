package ru.senla.bialevich.servlets;

import ru.senla.bialevich.model.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/evict")
public class EvictGuestServlet extends AbstractServlet {
    private static final long serialVersionUID = -7507682054893470129L;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Integer idGuest = Integer.parseInt(req.getParameter("idGuest"));

        Guest guest = hotel.getGuest(idGuest);

        hotel.evictGuest(guest);

        writer.write("Evict guest is success.");
    }
}
