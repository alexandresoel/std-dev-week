package me.alexandresoel.service;

import me.alexandresoel.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);

    void deleteById(Long id);


}
