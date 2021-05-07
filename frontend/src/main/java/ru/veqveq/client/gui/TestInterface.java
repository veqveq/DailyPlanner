package ru.veqveq.client.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.veqveq.client.gui.utils.SceneCreator;

public class TestInterface extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader loader = new FXMLLoader();
//        URL url = getClass().getResource("/ru/veqveq/client/gui/main-scene.fxml");
//        loader.setLocation(url);
//        Parent root = loader.load();
        Parent root = SceneCreator.getInstance().createScene("main-scene");
        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Test");
        stage.show();
    }
}
