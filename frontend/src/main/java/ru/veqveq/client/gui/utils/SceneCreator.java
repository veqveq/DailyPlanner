package ru.veqveq.client.gui.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class SceneCreator {
    private static volatile SceneCreator instance;
    private static final String ROOT_PATH = "/ru/veqveq/client/gui/";
    private static final String COMPONENT_PATH = ROOT_PATH + "nodes/";

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

    public void loadComponent(String fxmlName, Parent root) {
        URL url = getClass().getResource(COMPONENT_PATH + validFxmlName(fxmlName));
        FXMLLoader loader = new FXMLLoader(url);
        loader.setRoot(root);
        loader.setController(root);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Parent createScene(String fxmlName) {
        try {
            URL url = getClass().getResource(ROOT_PATH + validFxmlName(fxmlName));
            return FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String validFxmlName(String name) {
        if (!name.endsWith(".fxml")) {
            return name.concat(".fxml");
        }
        return name;
    }
}
