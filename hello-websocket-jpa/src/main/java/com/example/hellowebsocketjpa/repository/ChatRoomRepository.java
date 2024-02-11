package com.example.hellowebsocketjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hellowebsocketjpa.domain.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
