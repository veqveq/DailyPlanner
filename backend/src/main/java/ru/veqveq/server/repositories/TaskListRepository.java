package ru.veqveq.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.veqveq.server.models.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    void deleteById(Long id);
}
