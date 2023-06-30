package ru.kataacademy.Filatov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataacademy.Filatov.model.User;
import ru.kataacademy.Filatov.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public User findOne(int id) {
        Optional<User> findUser = usersRepository.findById(id);
        return findUser.orElse(null);
    }
    public List<User> findAll(){
        return usersRepository.findAll();
    }
    @Transactional
    public void save(User user) {
        usersRepository.save(user);
    }
    @Transactional
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        usersRepository.save(updatedUser);
    }
    @Transactional
    public void delete(int id) {
        usersRepository.deleteById(id);
    }
}
