package ru.veqveq.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.veqveq.client.gui.ClientFxApplication;

import java.awt.*;
import java.io.InputStream;
import java.net.URL;

@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        Application.launch(ClientFxApplication.class, args);
        SpringApplication.run(ClientApplication.class,args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Планировщик задач");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        InputStream stageLogo = getClass().getResourceAsStream("/gui/img/stagelogo.png");
        Image icon = new Image(stageLogo);
        primaryStage.getIcons().add(icon);

        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("/gui/mainScene.fxml");
        loader.setLocation(url);
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
