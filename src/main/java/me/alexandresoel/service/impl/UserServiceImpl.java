package me.alexandresoel.service.impl;

import me.alexandresoel.model.User;
import me.alexandresoel.repository.UserRepository;
import me.alexandresoel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsById(userToCreate.getId())){
           throw new IllegalArgumentException("Esse usuário já existe");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
