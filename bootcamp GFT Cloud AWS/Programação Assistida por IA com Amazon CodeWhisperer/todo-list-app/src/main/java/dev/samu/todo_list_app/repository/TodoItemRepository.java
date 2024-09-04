package dev.samu.todo_list_app.repository;

import dev.samu.todo_list_app.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoItemRepository extends JpaRepository<TodoItem, UUID> {
}
