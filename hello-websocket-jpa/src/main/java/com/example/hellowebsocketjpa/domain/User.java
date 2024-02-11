package com.example.hellowebsocketjpa.domain;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id")
	private Long id;

	private String name;
}
