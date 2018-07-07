package com.todo.dao.repo;

import com.todo.domain.Todo;
import com.todo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUser(User user);
    Todo findByIdAndUser(Long id,User user);
}
