package ru.veqveq.client.gui.nodes;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.veqveq.client.models.Task;
import ru.veqveq.client.services.TaskService;
import ru.veqveq.nodes.AlwaysExpandedAccordion;
import ru.veqveq.utils.SceneCreator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static ru.veqveq.client.gui.ClientFxApplication.COMPONENT_PATH;

@Component
@FxmlView(COMPONENT_PATH + "timelist/timelist")
public class TimeList extends AlwaysExpandedAccordion implements TaskListView {
    private TaskService taskService;

    @FXML
    private Pane toDay, toWeek, toMonth, other, expired;

    public TimeList() {
        SceneCreator.getInstance().loadComponent(COMPONENT_PATH + "timelist/time-list", this);
        getStyleClass().add("time-list");
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void init() {
        List<Task> taskList = taskService.findAll();
        for (Task t : taskList) {
            initTaskNode(t, getCurrentPane(t));
        }
        getCurrentPane().getChildren().addListener((ListChangeListener<Node>) change -> {
            change.next();
            if (change.wasRemoved()) {
                change.getRemoved().forEach(node ->
                        taskService.remove(((TaskNode) node)));
            }
        });
    }

    @Override
    public TaskNode addTask(Task task) {
        return initTaskNode(task, getCurrentPane(task));
    }

    public TaskNode initTaskNode(Task task, Pane pane) {
        TaskNode taskNode = new TaskNode(task);
        taskNode.updatedProperty().addListener((observableValue, aBoolean, t1) -> {
            if (t1) taskService.update(taskNode);
            taskNode.setUpdated(false);
        });
        pane.getChildren().add(taskNode);
        return taskNode;
    }

    public Pane getCurrentPane(Task task) {
        if (task.getDeadline() != null) {
            long dTime = ChronoUnit.DAYS.between(LocalDate.now(), task.getDeadline());
            if (dTime == 0) return toDay;
            if (dTime < 0) return expired;
            if (dTime < 7) return toWeek;
            if (dTime < 30) return toMonth;
        }
        return other;
    }

    public Pane getCurrentPane() {
        return (Pane) ((ScrollPane) this.getExpandedPane().getContent()).getContent();
    }
}
