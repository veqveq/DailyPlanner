package ru.veqveq.client.gui.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Tab;

import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import ru.veqveq.client.gui.nodes.TaskListView;
import ru.veqveq.client.gui.nodes.TimeList;
import ru.veqveq.client.models.Task;
import ru.veqveq.client.services.TaskService;

import static ru.veqveq.client.gui.ClientFxApplication.ROOT_PATH;

@Component
@RequiredArgsConstructor
@FxmlView(ROOT_PATH + "main-scene.fxml")
public class MainController {

    private final TaskService taskService;
    private final TimeList timeList;

    public Tab tasksTabPane;
    private ObjectProperty<TaskListView> current;

    public void createTask(ActionEvent actionEvent) {
        Task task = new Task();
        taskService.save(task);
        current.getValue().addTask(task).edit();
    }

    @FXML
    private void initialize() {
        current = new SimpleObjectProperty<>();
        current.addListener((observableValue, taskListView, t1) -> current.getValue().init());
        current.setValue(timeList);
        tasksTabPane.setContent((Node) current.getValue());
    }
}
