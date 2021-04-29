package ru.veqveq.client;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.veqveq.client.gui.ClientFxApplication;


@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        Application.launch(ClientFxApplication.class, args);
    }
}
