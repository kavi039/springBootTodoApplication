package com.todo.service;

import com.todo.co.UserCo;
import com.todo.dao.repo.UserRepository;
import com.todo.domain.User;
import com.todo.dto.ResponseDTO;
import com.todo.enums.EntityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Transactional
    public void addUser(UserCo userCo) {
      Long emailCount =  userRepository.countUserByEmail(userCo.getEmail());
        if (emailCount > 0) {
            throw new RuntimeException();
        }
        User user = new User();
        user.setEmail(userCo.getEmail());
        user.setAddress(userCo.getAddress());
        byte[] password = userCo.getPassword().getBytes();
        user.setPassword(Base64.getEncoder().encode(password).toString());
        userRepository.save(user);
    }
}
