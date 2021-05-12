package ru.veqveq.client.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import ru.veqveq.client.gui.nodes.TaskNode;
import ru.veqveq.client.gui.utils.SceneCreator;
import ru.veqveq.client.models.Task;
import ru.veqveq.nodes.AlwaysExpandedAccordion;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@FxmlView("main-scene.fxml")
public class MainController {
    public AnchorPane home;
    @FXML
    private AlwaysExpandedAccordion accordion;
    @FXML
    private VBox toDay, toWeek, toMonth;

    public void initialize() {
    }

    public void createTask(ActionEvent actionEvent) throws IOException {
        TaskNode newTask = new TaskNode();
        toDay.getChildren().addAll(newTask);
        newTask.edit();
    }
}
