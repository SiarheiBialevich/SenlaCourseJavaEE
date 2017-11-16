package ru.senla.bialevich;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8787;
    private static final Logger LOG = Logger.getLogger(Server.class);

    public static void main(String[] args) {
        ServerSocket server = null;

        try {
            ServerThread thread;
            server = new ServerSocket(PORT);

            while (true) {
                System.out.println("Waiting for a client...");
                Socket socket = server.accept();
                thread = new ServerThread(socket);
                System.out.println("Client " + thread.getName() + " connected.");
                thread.start();
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                assert server != null;
                server.close();
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
