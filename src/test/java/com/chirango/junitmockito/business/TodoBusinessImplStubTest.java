package com.chirango.junitmockito.business;

import com.chirango.junitmockito.api.TodoServiceStub;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoBusinessImplStubTest {

  @Test
  public void testRetrieveTodosRelatedToSpring_usingStub() {
    TodoServiceStub todoServiceStub = new TodoServiceStub();
    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
    List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

    Assertions.assertEquals(2, filteredTodos.size());
  }
}
