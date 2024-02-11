package com.example.hellowebsocketjpa.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.hellowebsocketjpa.dto.ChatMessageRequest;
import com.example.hellowebsocketjpa.dto.ChatMessageResponse;
import com.example.hellowebsocketjpa.service.ChatMessageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {
	private final ChatMessageService chatMessageService;

	@MessageMapping("/chat/rooms/{chatRoomId}")
	@SendTo("/queue/chat/rooms/{chatRoomId}")
	public ChatMessageResponse chatMessage(
		@DestinationVariable Long chatRoomId,
		@Payload ChatMessageRequest request
	){
		return chatMessageService.registerChatMessage(
			chatRoomId, request.senderId(), request.content()
		);
	}
}
