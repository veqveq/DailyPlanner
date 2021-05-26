package ru.veqveq.client.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.veqveq.client.gui.nodes.TaskNode;
import ru.veqveq.client.models.Task;
import ru.veqveq.client.repositories.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void save(Task task) {
        taskRepository.save(task);
        System.out.println("Saved");
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @SneakyThrows
    @Transactional
    public void update(TaskNode taskNode) {
        Task task = taskRepository.findById(taskNode.getTaskId()).orElseThrow(()->new Exception("Task not found"));
        task.update(taskNode);
        System.out.println("Updated");
    }

    public void remove(TaskNode taskNode) {
        taskRepository.deleteById(taskNode.getTaskId());
    }
}
