package ru.veqveq.client.gui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import ru.veqveq.client.gui.nodes.TaskNode;

@Component
@RequiredArgsConstructor
@FxmlView("main-scene.fxml")
public class MainController {

    @FXML private Accordion accordion;
    @FXML private TitledPane toDay;
    @FXML private TaskNode task;

    public void initialize() {
        accordion.setExpandedPane(toDay);
        task.setText("Hello");
    }

    public void titledPaneClicked(MouseEvent mouseEvent) {
        if (accordion.getExpandedPane()==null){
            accordion.setExpandedPane(toDay);
        }
    }
}
