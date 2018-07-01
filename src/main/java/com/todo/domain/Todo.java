package com.todo.domain;

import com.todo.enums.TodoStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Todo {
    @Id
    Long id;
    @ManyToOne
    @NotNull
    User user;
    String description;
    @Column(nullable = false)
    String task;
    Boolean status;
    @Column(nullable = false)
    TodoStatus todoStatus=TodoStatus.PENDING;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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