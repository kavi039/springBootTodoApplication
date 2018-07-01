package com.todo.service;

import com.todo.co.TodoCo;
import com.todo.dao.repo.TodoRepository;
import com.todo.dao.repo.UserRepository;
import com.todo.domain.Todo;
import com.todo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TodoRepository todoRepository;

    public void addList(TodoCo todoCo) {
        Todo todo =  new Todo();
        User user = userRepository.findById(new Long(1)).get();
        todo.setUser(user);
        todo.setTask(todoCo.getTask());
        todo.setDescription(todoCo.getDescription());
        todoRepository.save(todo);
    }
}
