package dev.samu.todo_list_app.repository;

import dev.samu.todo_list_app.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, UUID> {
}
