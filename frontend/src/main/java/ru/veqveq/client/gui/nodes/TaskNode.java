package ru.veqveq.client.gui.nodes;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import ru.veqveq.client.models.Task;
import ru.veqveq.nodes.RepaintButton;
import ru.veqveq.nodes.ResizableTextArea;
import ru.veqveq.utils.PseudoClassFactory;
import ru.veqveq.utils.SceneCreator;

import java.time.LocalDate;

import static ru.veqveq.client.gui.ClientFxApplication.COMPONENT_PATH;

public class TaskNode extends GridPane {
    @FXML
    private CheckBox checkBox;
    @FXML
    private ResizableTextArea text, title;
    @FXML
    private Button delButton;
    @FXML
    private RepaintButton quickBt, importantBt;
    @FXML
    private DatePicker deadline;

    private final BooleanProperty completed;
    private final BooleanProperty edited;
    private final BooleanProperty updated;
    private Long taskId;

    public TaskNode(Task task) {
        this();
        this.taskId = task.getId();
        if (task.getTitle() != null) title.setText(task.getTitle());
        if (task.getText() != null) text.setText(task.getText());
        if (task.getImportant() != null) importantBt.tapedProperty().setValue(task.getImportant());
        if (task.getQuickly() != null) quickBt.tapedProperty().setValue(task.getQuickly());
        if (task.getDeadline() != null) deadline.setValue(task.getDeadline());
        title.setEditable(false);
        text.setEditable(false);
    }

    private TaskNode() {
        SceneCreator.getInstance().loadComponent(COMPONENT_PATH + "tasknode/task-node", this);
        getStyleClass().add("task-node");
        this.completed = new SimpleBooleanProperty(false);
        this.edited = new SimpleBooleanProperty(false);
        this.updated = new SimpleBooleanProperty();
        edited.addListener((observableValue, oldValue, newValue) -> {
            if (oldValue && !newValue) setUpdated(true);
        });
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

        quickBt.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> Platform.runLater(() -> setUpdated(true)));
        importantBt.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> Platform.runLater(() -> setUpdated(true)));
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

    public boolean isUpdated() {
        return updated.get();
    }

    public BooleanProperty updatedProperty() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated.setValue(updated);
    }

    public void changeStatus() {
        setCompleted(!getCompleted());
    }


    public Long getTaskId() {
        return taskId;
    }

    public String getText() {
        return text.getText();
    }

    public String getTitle() {
        return title.getText();
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

    public boolean isQuickly() {
        return quickBt.tapedProperty().getValue();
    }

    public boolean isImportant() {
        return importantBt.tapedProperty().getValue();
    }

    public LocalDate getDeadline() {
        return deadline.getValue();
    }
}
