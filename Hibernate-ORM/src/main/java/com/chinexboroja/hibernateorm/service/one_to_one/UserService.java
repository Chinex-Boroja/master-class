package com.chinexboroja.hibernateorm.service.one_to_one;

import com.chinexboroja.hibernateorm.entity.one_to_one.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User createUser(User user);

    public void deleteUser(Long id);
}
