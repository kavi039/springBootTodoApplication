package com.todo.domain;

import com.todo.enums.EntityStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    private Long id;
    private String email;
    private String password;
    private String address;
    @Column(name = "status")
    private EntityStatus entityStatus = EntityStatus.ENABLE;
    private Set<Todo> todos = new HashSet<Todo>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EntityStatus getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(EntityStatus entityStatus) {
        this.entityStatus = entityStatus;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Todo> getTodos() {
        return this.todos;
    }

    public void getTodos(HashSet<Todo> todos) {
        this.todos=todos;
    }
}
