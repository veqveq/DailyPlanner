package ru.veqveq.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.veqveq.server.models.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOwnerUsername(String ownerUsername);

    List<Task> findAllByTaskListId(Long taskListId);

    void deleteAllByTaskListId(Long taskListId);
}
