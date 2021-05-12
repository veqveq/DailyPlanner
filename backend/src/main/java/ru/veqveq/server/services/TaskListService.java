package ru.veqveq.server.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.veqveq.server.models.Task;
import ru.veqveq.server.models.TaskList;
import ru.veqveq.server.repositories.TaskListRepository;
import ru.veqveq.server.repositories.TaskRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskListService {
    public final TaskListRepository taskListRepository;
    public final TaskRepository taskRepository;

    @Transactional
    public Long create(String title) {
        TaskList taskList = new TaskList(title);
        taskListRepository.save(taskList);
        return taskList.getId();
    }

    public List<TaskList> findAll(String username) {
        return taskRepository.findAllByOwnerUsername(username)
                .stream()
                .map(Task::getTaskList)
                .distinct()
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeTaskList(Long taskListId) {
        taskRepository.findAllByTaskListId(taskListId)
                .forEach((t) -> t.setTaskList(null));
    }

    public void removeTaskListAndAllTasks(Long taskListId) {
        taskRepository.deleteAllByTaskListId(taskListId);
    }
}
