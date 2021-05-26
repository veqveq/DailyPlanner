package ru.veqveq.client.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.veqveq.utils.SceneCreator;

import static ru.veqveq.client.gui.ClientFxApplication.ROOT_PATH;

public class TestInterface extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = SceneCreator.getInstance().createScene(ROOT_PATH + "main-scene");
        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Test");
        stage.show();
    }
}
