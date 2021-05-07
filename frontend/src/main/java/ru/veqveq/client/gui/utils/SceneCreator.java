package ru.veqveq.client.gui.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class SceneCreator {
    private static volatile SceneCreator instance;
    private static final String ROOT_PATH = "/ru/veqveq/client/gui/";

    private SceneCreator() {
    }

    public static SceneCreator getInstance() {
        SceneCreator localInstance = instance;
        if (localInstance == null) {
            synchronized (SceneCreator.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SceneCreator();
                }
            }
        }
        return localInstance;
    }

    public Parent createScene(String fxmlName) {
        if (!fxmlName.endsWith(".fxml")) {
            fxmlName = fxmlName + ".fxml";
        }
        try {

            URL url = getClass().getResource(ROOT_PATH + fxmlName);
            return FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
