package com.chirango.junitmockito.business;

import com.chirango.junitmockito.api.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoBusinessImpl {

  @Autowired private TodoService todoService;

  public List<String> retrieveTodosRelatedToSpring(String user) {
    List<String> filteredTodos = new ArrayList<>();
    List<String> todos = todoService.retrieveTodos(user);
    for (String todo : todos) {
      if (todo.contains("Spring")) {
        filteredTodos.add(todo);
      }
    }

    return filteredTodos;
  }
}
