package com.todo.domain;

import com.todo.enums.TodoStatus;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    Long id;
    User user;
    String description;
    String task;
    Boolean status;
    TodoStatus todoStatus=TodoStatus.PENDING;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinColumn(name = "id",nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TodoStatus getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(TodoStatus todoStatus) {
        this.todoStatus = todoStatus;
    }
}
