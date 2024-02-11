package com.example.hellowebsocketjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hellowebsocketjpa.domain.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
