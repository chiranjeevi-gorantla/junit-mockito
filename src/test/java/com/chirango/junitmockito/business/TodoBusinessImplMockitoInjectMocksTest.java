package com.chirango.junitmockito.business;

import com.chirango.junitmockito.api.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TodoBusinessImplMockitoInjectMocksTest {

  @Mock private TodoService todoService;

  @InjectMocks private TodoBusinessImpl todoBusinessImpl;

  @Test
  void testRetrieveTodosRelatedToSpring_usingMock() {

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Guiter");
    Mockito.when(todoService.retrieveTodos("Dummy")).thenReturn(todos);

    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

    Assertions.assertEquals(2, filteredTodos.size());
  }

  @Test
  void testRetrieveTodosRelatedToSpring_withEmptyList() {

    List<String> todos = Arrays.asList();
    Mockito.when(todoService.retrieveTodos("Dummy")).thenReturn(todos);

    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

    Assertions.assertEquals(0, filteredTodos.size());
  }
}
