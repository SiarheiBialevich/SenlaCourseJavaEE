package ru.senla.bialevich.request.src.ru.senla.bialevich;

import java.io.Serializable;

public class DataPackage implements Serializable {

    private static final long serialVersionUID = 3122735474881974595L;

    private String header;
    private Object body;

    public DataPackage(String header, Object body) {
        this.header = header;
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
