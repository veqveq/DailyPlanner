package ru.veqveq.client.gui.nodes;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import ru.veqveq.nodes.ResizableTextArea;

import java.io.IOException;

public class TaskNode extends GridPane {
    @FXML
    private RadioButton radio;
    @FXML
    private ResizableTextArea text;
    private StringProperty taskText;
        private BooleanProperty status;

    public TaskNode(String text) {
        new TaskNode();
        this.text.setText(text);
    }

    public TaskNode() {
        this.taskText = new SimpleStringProperty();
        getStyleClass().add("task-node");
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/ru/veqveq/nodes/task-node.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.status = new SimpleBooleanProperty(false);
        status.addListener(new InvalidationListener() {
            public void invalidated(Observable e) {
                TaskNode.this.pseudoClassStateChanged(PseudoClass.getPseudoClass("status"), status.get());
            }
        });
        radio.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                TaskNode.this.changeStatus();
            }
        });
    }

    public boolean isStatus() {
        return status.get();
    }

    public void setStatus(boolean status) {
        this.status.set(status);
    }

    public void changeStatus() {
        setStatus(!isStatus());
        text.setDisable(isStatus());
    }

    public String getTaskText() {
        return taskText.get();
    }

    public StringProperty taskTextProperty() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText.set(taskText);
    }

    @FXML
    private void edit() {
        if (text.isEditable()) {
            text.setEditable(false);
            text.setStyle("-fx-font-style: normal");
            taskText.setValue(text.getText());
        } else {
            text.setEditable(true);
            text.setStyle("-fx-font-weight: bolder; -fx-font-size: 110%");
        }
    }
}
