package ru.senla.bialevich;

import org.apache.log4j.Logger;
import ru.senla.bialevich.invoker.MethodInvoker;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private static final Logger LOG = Logger.getLogger(ServerThread.class);
    private Socket client;

    public ServerThread(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        ObjectInputStream ois;
        ObjectOutputStream oos;

        try {
            ois = new ObjectInputStream(client.getInputStream());
            oos = new ObjectOutputStream(client.getOutputStream());

            while (true) {
                DataPackage request = (DataPackage) ois.readObject();

                if (request != null) {
                    oos.writeObject(MethodInvoker.invokeMethod(request.getHeader(), request.getBody()));
                    oos.flush();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
