package ru.veqveq.client.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import ru.veqveq.client.gui.utils.SceneCreator;
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
    private TitledPane toDay;

    public void initialize() {
        accordion.setExpandedPane(toDay);
    }

    public void createTask(ActionEvent actionEvent) throws IOException {
        List<TitledPane> panes = accordion.getPanes();
        home.getChildren().setAll(SceneCreator.getInstance().createScene("create-task-scene"));
    }
}
