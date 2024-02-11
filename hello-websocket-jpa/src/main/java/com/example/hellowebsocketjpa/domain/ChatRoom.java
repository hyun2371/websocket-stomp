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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ChatRoom extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "chat_room_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "buyer_id")
	private User buyer;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "seller_id")
	private User seller;
}
