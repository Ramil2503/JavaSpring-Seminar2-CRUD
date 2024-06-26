package org.example.javaspringseminar2crud.service;

import org.example.javaspringseminar2crud.model.User;
import org.example.javaspringseminar2crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) { userRepository.deleteById(id); }

    public void editUser(int id, String firstName, String lastName) { userRepository.editUser(id, firstName, lastName); }
}