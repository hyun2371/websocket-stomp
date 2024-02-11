package com.example.hellowebsocketjpa.dto;

import java.time.LocalDateTime;

import com.example.hellowebsocketjpa.domain.ChatMessage;

public record ChatMessageResponse(
	Long chatRoomId,
	Long senderId,
	String content,
	LocalDateTime createdAt
) {
	public static ChatMessageResponse from(ChatMessage chatMessage) {
		return new ChatMessageResponse(
			chatMessage.getChatRoom().getId(),
			chatMessage.getSenderId(),
			chatMessage.getContent(),
			chatMessage.getCreatedAt()
		);
	}
}
