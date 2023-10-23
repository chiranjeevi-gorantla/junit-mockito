package com.chirango.junitmockito.business;

import com.chirango.junitmockito.api.TodoService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TodoBusinessImplMockTest {

  @Test
  void testRetrieveTodosRelatedToSpring_usingMock() {

    TodoService todoServiceMock = Mockito.mock(TodoService.class);
    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Guiter");

    Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

    Assertions.assertEquals(2, filteredTodos.size());
  }

  @Test
  void testRetrieveTodosRelatedToSpring_withEmptyList() {

    TodoService todoServiceMock = Mockito.mock(TodoService.class);
    List<String> todos = Arrays.asList();

    Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

    Assertions.assertEquals(0, filteredTodos.size());
  }

  // BDD
  @Test
  void testRetrieveTodosRelatedToSpring_usingBDD() {
    // Given
    TodoService todoServiceMock = Mockito.mock(TodoService.class);
    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Guiter");
    Mockito.when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    // When
    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

    // Then
    Assertions.assertEquals(2, filteredTodos.size());
  }
}
