package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sumPayment")
public class GetSumPaymentRoomServlet extends AbstractServlet {
    private static final long serialVersionUID = -9190662561506828265L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        resp.setContentType(JSON);

        Integer idGuest = Integer.parseInt(req.getParameter("idGuest"));
        Integer idRoom = Integer.parseInt(req.getParameter("idRoom"));

        Guest guest = hotel.getGuest(idGuest);
        Room room = hotel.getRoom(idRoom);

        Double sum = hotel.getSumPaymentRoom(guest, room);

        writer.write(String.valueOf(sum));
    }
}
