package ru.veqveq.client.gui.nodes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.*;

import javax.swing.text.StyleConstants;
import java.awt.font.TextAttribute;
import java.util.Arrays;

public class TaskNode extends HBox {
    private Label text;
    private RadioButton statusRadio;
    private boolean status = true;

    public TaskNode() {
        getStyleClass().addAll(Arrays.asList("task-node", "active"));
        this.text = new Label();
        text.setWrapText(true);
        this.statusRadio = new RadioButton();
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(10);
        setPadding(new Insets(10));
        getChildren()
                .addAll(statusRadio, text);
        statusRadio.setOnAction(actionEvent -> changeStatus());
    }

    public void changeStatus() {
        status = !status;
        getStyleClass().remove(1);
        if (status) {
            text.setDisable(false);
            getStyleClass().add(1, "active");
        } else {
            text.setDisable(true);
            getStyleClass().add(1, "deactive");
        }
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}
