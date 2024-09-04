package dev.samu.todo_list_app.service;

import dev.samu.todo_list_app.model.TodoList;
import dev.samu.todo_list_app.repository.TodoListRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TodoListServiceTest {

    @Mock
    private TodoListRepository todoListRepository;

    @InjectMocks
    private TodoListService todoListService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_createTodoList() {

        //given - cenário - Preparação dos Dados
        TodoList fakeTodoList = TodoList.builder()
                .id(UUID.randomUUID())
                .title("fake title")
                .build();
        Mockito.when(todoListRepository.save(Mockito.any())).thenReturn(fakeTodoList);

        //when - ação
        TodoList actual = todoListService.createTodoList(fakeTodoList);

        //then - resultado - Verificação
        Assertions.assertThat(actual).isEqualTo(fakeTodoList);
        Assertions.assertThat(actual.getItems()).isNullOrEmpty();
    }

    @Test
    void should_getTodoListById() {

        //given - cenário
        UUID fakeId = UUID.randomUUID();
        TodoList fakeTodoList = TodoList.builder()
                .id(fakeId)
                .title("fake title")
                .build();
        Mockito.when(todoListRepository.findById(fakeId)).thenReturn(Optional.of(fakeTodoList));

        //when - ação
        TodoList actual = todoListService.getTodoList(fakeId);

        //then - resultado
        Assertions.assertThat(actual).isEqualTo(fakeTodoList);
        Assertions.assertThat(actual.getItems()).isNullOrEmpty();
    }

    @Test
    void should_throwException_when_getTodoListById_notFound() {
        // Given - cenário
        UUID fakeId = UUID.randomUUID();
        Mockito.when(todoListRepository.findById(fakeId)).thenReturn(Optional.empty());

        // When - ação & Then - resultado
        IllegalStateException thrown = assertThrows(
                IllegalStateException.class,
                () -> todoListService.getTodoList(fakeId)
        );
        Assertions.assertThat(thrown.getMessage()).isEqualTo("TodoList with id " + fakeId + " does not exist.");
    }


    @Test
    void should_getAllTodoLists() {

        //given - cenário
        TodoList fakeTodoList = TodoList.builder()
                .id(UUID.randomUUID())
                .title("fake title")
                .build();

        TodoList fakeTodoList2 = TodoList.builder()
                .id(UUID.randomUUID())
                .title("fake title 2")
                .build();

        Mockito.when(todoListRepository.findAll()).thenReturn(List.of(fakeTodoList, fakeTodoList2));

        //when - ação
        List<TodoList> actual = todoListService.getAllTodoLists();

        //then - resultado
        Assertions.assertThat(actual).contains(fakeTodoList);
        Assertions.assertThat(actual).contains(fakeTodoList2);
        Assertions.assertThat(actual).hasSize(2);
    }

    @Test
    void should_returnEmptyList_when_noTodoLists() {
        // Given - cenário
        Mockito.when(todoListRepository.findAll()).thenReturn(List.of());

        // When - ação
        List<TodoList> actual = todoListService.getAllTodoLists();

        // Then - resultado
        Assertions.assertThat(actual).isEmpty();
    }


    @Test
    void should_updateTodoList() {

        //given - cenário
        UUID fakeId = UUID.randomUUID();
        TodoList oldFakeTodoList = TodoList.builder()
                .id(fakeId)
                .title("Old fake title")
                .build();

        TodoList updatedTodoList = TodoList.builder()
                .id(fakeId)
                .title("Updated fake title")
                .build();

        Mockito.when(todoListRepository.findById(fakeId)).thenReturn(Optional.of(oldFakeTodoList));
        Mockito.when(todoListRepository.save(Mockito.any())).thenReturn(updatedTodoList);

        //when - ação
        TodoList actual = todoListService.updateTodoList(fakeId, updatedTodoList);

        //then - resultado
        Assertions.assertThat(actual).isEqualTo(updatedTodoList);
        Assertions.assertThat(actual.getItems()).isNullOrEmpty();
    }

    @Test
    void should_throwException_when_updateTodoList_notFound() {
        // Given - cenário
        UUID fakeId = UUID.randomUUID();
        TodoList updatedTodoList = TodoList.builder()
                .id(fakeId)
                .title("Updated fake title")
                .build();
        Mockito.when(todoListRepository.findById(fakeId)).thenReturn(Optional.empty());

        // When & Then - resultado
        assertThrows(IllegalStateException.class, () -> todoListService.updateTodoList(fakeId, updatedTodoList));
    }


    //create a test method for deleteTodoList()

    @Test
    void should_deleteTodoList() {

        // Given - cenário
        UUID fakeId = UUID.randomUUID();
        TodoList fakeTodoList = TodoList.builder()
                .id(fakeId)
                .title("Fake title")
                .build();

        // When - ação
        Mockito.when(todoListRepository.findById(fakeId)).thenReturn(Optional.of(fakeTodoList));
        Mockito.doNothing().when(todoListRepository).deleteById(fakeId);
        todoListService.deleteTodoList(fakeId);

        // Then - resultado
        Mockito.verify(todoListRepository, Mockito.times(1)).deleteById(fakeId);
    }
}
