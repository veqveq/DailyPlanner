package ru.veqveq.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.veqveq.server.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
