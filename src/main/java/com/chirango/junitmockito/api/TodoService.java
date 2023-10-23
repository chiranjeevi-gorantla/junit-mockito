package com.chirango.junitmockito.api;


import java.util.List;

public interface TodoService {
  List<String> retrieveTodos(String user);
}
