package com.example.hellowebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // 메시지 브로커에 의해 수행되는 WebSocket 메시지 처리 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	/*
	- enable simple broker
	간단한 메모리 기반 메시지 브로커 활성화
	목적지 prefix가 /topic인 클라이언트에게 greeting message를 전달

	/app : @MessageMapping 메서드로 향하는 메세지들에 대해 /app prefix 지정
	app prefix는 모든 MessageMapping을 정의하는데 사용한다.
	ex) /app/hello는 GreetingController.greeting() 메서드로 가는 경로이다.
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		/*
		웹소켓 연결 엔드포인트 지정
		 */
		registry.addEndpoint("/gs-guide-websocket");
	}
}
