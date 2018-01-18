package ru.senla.bialevich.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/roomSorting")
public class RoomSortingServlet extends AbstractServlet {
    private static final long serialVersionUID = -5230014068680053374L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();

        resp.setContentType(JSON);

        if ((req.getQueryString() == "") || (req.getQueryString() == null)) {
            List<Room> rooms = hotel.getAllRooms(SortType.id);
            writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rooms));
        } else {
            SortType type = this.getSort(req.getParameter("type"));
            List<Room> rooms = hotel.getAllRooms(type);

            writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rooms));
        }
    }

    public SortType getSort(String query) {
        SortType type = null;
        for (SortType sortType : SortType.values()) {
            if (sortType.getSort().equals(query)) {
                type = sortType;
            }
        }
        return type;
    }
}
