package com.todo.service;

import com.todo.co.UserCo;
import com.todo.dao.repo.UserRepository;
import com.todo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.Objects;

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

    public void updateUser(Long id, UserCo userCo){
        User user = userRepository.findById(id).get();
        if (Objects.nonNull(user)) {
            if (Objects.nonNull(userCo.getEmail()) && !userCo.getEmail().equals("")) {
                user.setEmail(userCo.getEmail());
            }
            if (Objects.nonNull(userCo.getAddress()) && !userCo.getAddress().equals("")){
               user.setAddress(userCo.getAddress());
            }
            if (Objects.nonNull(userCo.getPassword()) &&!userCo.getPassword().equals("")) {
                user.setPassword(Base64.getEncoder().encode(userCo.getPassword().getBytes()).toString());
            }
            userRepository.save(user);
        }
    }

    public void deleteUser (Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public boolean validateUser() {
        return true;
    }
}
