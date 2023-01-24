package ru.itmo.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<InternalUser, String> {
    InternalUser findByLogin(String login);
}