package com.example.hellowebsocketjpa.dto;

public record ChatMessageRequest (
	Long senderId,
	String content
){}