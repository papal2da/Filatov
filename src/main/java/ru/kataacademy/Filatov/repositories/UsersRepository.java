package ru.kataacademy.Filatov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kataacademy.Filatov.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

}
