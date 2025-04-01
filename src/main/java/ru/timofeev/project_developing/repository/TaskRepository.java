package ru.timofeev.project_developing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.timofeev.project_developing.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
