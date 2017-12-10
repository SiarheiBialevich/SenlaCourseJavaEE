package ru.senla.bialevich.ui;

import ru.senla.bialevich.IRequestHandler;

public interface IAction {
    void execute(IRequestHandler requestHandler);
}
