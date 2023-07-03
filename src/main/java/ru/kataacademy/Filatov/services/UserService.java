package ru.kataacademy.Filatov.services;

import ru.kataacademy.Filatov.model.User;

import java.util.List;

public interface UserService {
    public User findOne(int id);
    public List<User> findAll();

    public void save(User user);
    public void update(int id, User updatedUser);

    public void delete(int id);
}
