package ru.veqveq.client.gui.nodes;

import ru.veqveq.client.models.Task;

public interface TaskListView {
    void init();

    TaskNode addTask(Task task);
}
