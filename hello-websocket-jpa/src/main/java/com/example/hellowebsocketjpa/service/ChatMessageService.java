package com.example.hellowebsocketjpa.service;

import org.springframework.stereotype.Service;

import com.example.hellowebsocketjpa.domain.ChatMessage;
import com.example.hellowebsocketjpa.domain.ChatRoom;
import com.example.hellowebsocketjpa.dto.ChatMessageResponse;
import com.example.hellowebsocketjpa.repository.ChatMessageRepository;
import com.example.hellowebsocketjpa.repository.ChatRoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
	private final ChatMessageRepository chatMessageRepository;
	private final ChatRoomRepository chatRoomRepository;

	public ChatMessageResponse registerChatMessage(
		Long chatRoomId,
		Long senderId,
		String content){
		ChatMessage chatMessage = saveChatMessage(chatRoomId, senderId, content);
		return ChatMessageResponse.from(chatMessage);
	}

	private ChatMessage saveChatMessage(
		Long chatRoomId,
		Long senderId,
		String content
	) {
		ChatRoom chatRoom = getChatRoomEntity(chatRoomId);
		ChatMessage chatMessage = new ChatMessage(chatRoom, senderId, content);
		chatMessageRepository.save(chatMessage);
		return chatMessage;
	}

	private ChatRoom getChatRoomEntity(Long chatRoomId) {
		return chatRoomRepository.findById(chatRoomId).orElseThrow(RuntimeException::new);
	}
}
