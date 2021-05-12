package ru.veqveq.client.gui.utils;

import javafx.beans.property.BooleanProperty;
import javafx.css.PseudoClass;
import javafx.scene.Node;

import java.lang.reflect.Field;

public class PseudoClassFactory {
    private static volatile PseudoClassFactory instance;

    public static PseudoClassFactory getInstance() {
        PseudoClassFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (SceneCreator.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PseudoClassFactory();
                }
            }
        }
        return localInstance;
    }

    public void create(Node node, String name, String... names) {
        parseField(node, name);
        for (String n : names) {
            parseField(node, n);
        }
    }

    private void parseField(Node node, String name) {
        try {
            Field field = node.getClass().getDeclaredField(name);
            field.setAccessible(true);
            addListener(node, (BooleanProperty) field.get(node), name);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void addListener(Node root, BooleanProperty property, String name) {
        property.addListener(e -> root.pseudoClassStateChanged(PseudoClass.getPseudoClass(name), property.get()));
    }

}
