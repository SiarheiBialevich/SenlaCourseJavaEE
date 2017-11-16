package ru.senla.bialevich.api;

import ru.senla.bialevich.IRequestHandler;

public interface IAction {
    void execute(IRequestHandler requestHandler);
}
