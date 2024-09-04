package dev.samu.todo_list_app.service;

import dev.samu.todo_list_app.model.TodoItem;
import dev.samu.todo_list_app.repository.TodoItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemServiceTest {

    @Mock
    private TodoItemRepository todoItemRepository;

    @Mock
    private TodoListService todoListService; // Se necessário para os testes

    @InjectMocks
    private TodoItemService todoItemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_createTodoItem() {
        // Given - cenário
        TodoItem fakeTodoItem = TodoItem.builder()
                .id(UUID.randomUUID())
                .description("fake description")
                .completed(false)
                .build();
        Mockito.when(todoItemRepository.save(Mockito.any())).thenReturn(fakeTodoItem);

        // When - ação
        TodoItem actual = todoItemService.createTodoItem(fakeTodoItem);

        // Then - resultado
        Assertions.assertThat(actual).isEqualTo(fakeTodoItem);
    }

    @Test
    void should_getTodoItemById() {
        // Given - cenário
        UUID fakeId = UUID.randomUUID();
        TodoItem fakeTodoItem = TodoItem.builder()
                .id(fakeId)
                .description("fake description")
                .completed(false)
                .build();
        Mockito.when(todoItemRepository.findById(fakeId)).thenReturn(Optional.of(fakeTodoItem));

        // When - ação
        TodoItem actual = todoItemService.getTodoItem(fakeId);

        // Then - resultado
        Assertions.assertThat(actual).isEqualTo(fakeTodoItem);
    }

    @Test
    void should_throwException_when_getTodoItemById_notFound() {
        // Given - cenário
        UUID fakeId = UUID.randomUUID();
        Mockito.when(todoItemRepository.findById(fakeId)).thenReturn(Optional.empty());

        // When & Then - resultado
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> todoItemService.getTodoItem(fakeId)
        );
        Assertions.assertThat(thrown.getMessage()).isEqualTo("Todo item with id " + fakeId + " does not exist.");
    }

    @Test
    void should_deleteTodoItem() {
        // Given - cenário
        UUID fakeId = UUID.randomUUID();
        TodoItem fakeTodoItem = TodoItem.builder()
                .id(fakeId)
                .description("fake description")
                .completed(false)
                .build();

        // When - ação
        Mockito.when(todoItemRepository.findById(fakeId)).thenReturn(Optional.of(fakeTodoItem));
        Mockito.doNothing().when(todoItemRepository).deleteById(fakeId);
        todoItemService.deleteTodoItem(fakeId);

        // Then - resultado
        Mockito.verify(todoItemRepository, Mockito.times(1)).deleteById(fakeId);
    }

    @Test
    void should_updateTodoItem() {
        // Given - cenário
        UUID fakeId = UUID.randomUUID();
        TodoItem oldFakeTodoItem = TodoItem.builder()
                .id(fakeId)
                .description("Old description")
                .completed(false)
                .build();

        TodoItem updatedTodoItem = TodoItem.builder()
                .id(fakeId)
                .description("Updated description")
                .completed(true)
                .build();

        Mockito.when(todoItemRepository.findById(fakeId)).thenReturn(Optional.of(oldFakeTodoItem));
        Mockito.when(todoItemRepository.save(Mockito.any())).thenReturn(updatedTodoItem);

        // When - ação
        TodoItem actual = todoItemService.updateTodoItem(updatedTodoItem);

        // Then - resultado
        Assertions.assertThat(actual).isEqualTo(updatedTodoItem);
    }

    @Test
    void should_markTodoItemCompleted() {
        // Given - cenário
        UUID fakeId = UUID.randomUUID();
        TodoItem existingTodoItem = TodoItem.builder()
                .id(fakeId)
                .description("Some description")
                .completed(false)
                .build();

        TodoItem completedTodoItem = TodoItem.builder()
                .id(fakeId)
                .description("Some description")
                .completed(true)
                .build();

        Mockito.when(todoItemRepository.findById(fakeId)).thenReturn(Optional.of(existingTodoItem));
        Mockito.when(todoItemRepository.save(Mockito.any())).thenReturn(completedTodoItem);

        // When - ação
        TodoItem actual = todoItemService.markTodoItemCompleted(fakeId);

        // Then - resultado
        Assertions.assertThat(actual).isEqualTo(completedTodoItem);
    }
}
