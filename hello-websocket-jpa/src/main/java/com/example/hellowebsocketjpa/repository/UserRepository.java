package com.example.hellowebsocketjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hellowebsocketjpa.domain.ChatMessage;
import com.example.hellowebsocketjpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
