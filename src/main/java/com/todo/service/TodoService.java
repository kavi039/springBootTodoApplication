package com.todo.service;

import com.todo.co.TodoCo;
import com.todo.dao.repo.TodoRepository;
import com.todo.dao.repo.UserRepository;
import com.todo.domain.Todo;
import com.todo.domain.User;
import com.todo.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TodoService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession httpSession;

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

    public List<Todo> getTodoLists() {
        List<Todo> todoList = new ArrayList<>();
        if (Objects.nonNull(httpSession.getAttribute("user"))) {
            User user = userRepository.findById((Long) httpSession.getAttribute("user")).get();
            todoList = todoRepository.findAllByUser(user.getId());
        }
        return todoList;
    }
}
