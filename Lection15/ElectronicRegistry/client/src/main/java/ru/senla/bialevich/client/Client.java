package ru.senla.bialevich.client;

import org.apache.log4j.Logger;
import ru.senla.bialevich.menuItems.MenuController;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.request.src.ru.senla.bialevich.RequestHandlerImpl;

import java.io.IOException;
import java.net.Socket;


public class Client {
    private static final Logger LOG = Logger.getLogger(Client.class);
    private static final String ADDRESS = "localhost";
    private static final int PORT = 8787;

    public static void main(String[] args) {

        try {
            Socket client = new Socket(ADDRESS, PORT);
            IRequestHandler requestHandler = new RequestHandlerImpl(client);
            MenuController controller = new MenuController(requestHandler);
            controller.run();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
