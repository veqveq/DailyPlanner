package ru.veqveq.client.gui.nodes;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import ru.veqveq.client.gui.utils.PseudoClassFactory;
import ru.veqveq.client.gui.utils.SceneCreator;
import ru.veqveq.nodes.ResizableTextArea;

public class TaskNode extends GridPane {
    @FXML
    private CheckBox checkBox;
    @FXML
    private ResizableTextArea text, title;
    @FXML
    private Button delButton;
    private final BooleanProperty completed;
    private final BooleanProperty edited;

    public TaskNode(String text) {
        this();
        this.text.setText(text);
    }

    public TaskNode() {
        SceneCreator.getInstance().loadComponent("tasknode/task-node", this);
        getStyleClass().add("task-node");
        this.completed = new SimpleBooleanProperty(false);
        this.edited = new SimpleBooleanProperty(false);
        PseudoClassFactory.getInstance().create(this, "completed", "edited");
    }

    @FXML
    public void initialize() {
        checkBox.setOnAction(actionEvent -> TaskNode.this.changeStatus());
        title.setOnKeyPressed(keyEvent -> {
            if (!keyEvent.getCode().equals(KeyCode.ENTER)) return;
            text.requestFocus();
            if (!text.isEmpty()) text.positionCaret(text.getText().length());
            keyEvent.consume();
        });
        text.setOnKeyPressed(keyEvent -> {
            if (!keyEvent.getCode().equals(KeyCode.ENTER)) return;
            edit();
            keyEvent.consume();
        });
    }

    public boolean getCompleted() {
        return completed.get();
    }

    public void setCompleted(boolean completed) {
        this.completed.set(completed);
    }

    public boolean isEdited() {
        return edited.get();
    }

    public void setEdited() {
        this.edited.set(!isEdited());
    }

    public void changeStatus() {
        setCompleted(!getCompleted());
    }

    public void edit() {
        title.setEditable(!isEdited());
        text.setEditable(!isEdited());
        delButton.setDisable(!isEdited());
        if (!isEdited()) title.requestFocus();
        if (!title.isEmpty()) title.positionCaret(title.getText().length());
        setEdited();
    }

    public void remove() {
        Pane list = (Pane) this.getParent();
        list.getChildren().remove(this);
    }
}
