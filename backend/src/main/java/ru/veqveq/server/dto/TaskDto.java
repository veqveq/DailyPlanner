package ru.veqveq.server.dto;

import lombok.Data;
import ru.veqveq.server.models.Priority;
import ru.veqveq.server.models.Status;
import ru.veqveq.server.models.Task;
import ru.veqveq.server.models.TaskList;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TaskDto {
    private Long id;
    private TaskList taskList;
    private Status status;
    private Priority priority;
    private LocalDateTime deadline;
    private List<UserDto> executors;

    public TaskDto(Task task) {
        this.id = task.getId();
        this.taskList = task.getTaskList();
        this.status = task.getStatus();
        this.priority = task.getPriority();
        this.deadline = task.getDeadline();
        this.executors = task.getExecutors().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }
}
