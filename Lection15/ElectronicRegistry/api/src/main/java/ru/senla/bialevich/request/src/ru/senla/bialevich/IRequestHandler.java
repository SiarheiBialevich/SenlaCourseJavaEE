package ru.senla.bialevich.request.src.ru.senla.bialevich;

public interface IRequestHandler {
    Object sendRequest(DataPackage dataPackage);
    void disconnect();
}
