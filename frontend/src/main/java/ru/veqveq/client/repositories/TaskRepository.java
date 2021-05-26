package ru.veqveq.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.veqveq.client.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
