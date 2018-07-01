package com.todo.domain;

import com.todo.enums.TodoStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @NotNull
    User user;
    @Column(length = 500)
    String description;
    @Column(nullable = false, length = 5000)
    String task;
    @Column(nullable = false)
    String todoStatus=TodoStatus.PENDING.name();


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

    public String getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(String todoStatus) {
        this.todoStatus = todoStatus;
    }
}
