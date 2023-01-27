package com.demo.webflux_20230127.config;

import com.demo.webflux_20230127.dto.Greeting;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class GreetingClient {
    private final WebClient client;

    // Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
    // We can use it to create a dedicated `WebClient` for our component.

    // GreetingClient 클래스 주입시 WebClient 의 기본 설정을 진행 합니다.
    public GreetingClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }


    public Mono<String> getMessage() {
        return this.client.get().uri("/hello") // '/hello'로 요청이 들어오고
                .accept(MediaType.APPLICATION_JSON) // JSON 타입이면
                .retrieve() // 조회하고
                .bodyToMono(Greeting.class) // 응답을 Greeting 클래스형태의 Mono 로 변경하고
                .map(Greeting::getMessage); // Greeting 클래스의 message를 가지고 온다.
    }
}
