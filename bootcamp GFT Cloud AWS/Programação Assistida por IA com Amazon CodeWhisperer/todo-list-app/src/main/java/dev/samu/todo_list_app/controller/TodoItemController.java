package dev.samu.todo_list_app.controller;

import dev.samu.todo_list_app.model.TodoItem;
import dev.samu.todo_list_app.service.TodoItemService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/todo-items")
public record TodoItemController(

        TodoItemService todoItemService
) {

    @PostMapping
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.createTodoItem(todoItem);
    }

    @GetMapping("/{id}")
    public TodoItem getTodoItem(@PathVariable("id") UUID id) {
        return todoItemService.getTodoItem(id);
    }

    @PutMapping("/update")
    public TodoItem updateTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.updateTodoItem(todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable("id") UUID id) {
        todoItemService.deleteTodoItem(id);
    }

    @PatchMapping("/{id}/completed")
    public TodoItem markTodoItemCompleted(@PathVariable("id") UUID id) {
        return todoItemService.markTodoItemCompleted(id);
    }
}
