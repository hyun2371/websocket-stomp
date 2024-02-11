package com.example.hellowebsocketjpa.domain;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ChatMessage extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "chat_message_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "chat_room_id")
	private ChatRoom chatRoom;

	@Column(name = "sender_id")
	private Long senderId;

	private String content;

	@Builder
	public ChatMessage(ChatRoom chatRoom, Long senderId, String content) {
		this.chatRoom = chatRoom;
		this.senderId = senderId;
		this.content = content;
	}
}
