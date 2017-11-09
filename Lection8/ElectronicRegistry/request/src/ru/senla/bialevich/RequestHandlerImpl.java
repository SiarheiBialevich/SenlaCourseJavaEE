package ru.senla.bialevich;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestHandlerImpl implements IRequestHandler {

    private static final Logger LOG = Logger.getLogger(RequestHandlerImpl.class);
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public RequestHandlerImpl(Socket socket) {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public Object sendRequest(DataPackage dataPackage) {
        Object response = null;
        try {
            oos.writeObject(dataPackage);
            oos.flush();
            response = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
        }

        return response;
    }

    @Override
    public void disconnect() {
        try {
            saveDataAfterExit();
            oos.close();
            ois.close();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void saveDataAfterExit() {
        DataPackage dataPackage = new DataPackage("exportAll", null);
        sendRequest(dataPackage);
    }


}
