package com.example.reactivechatapp.controller;

import com.example.reactivechatapp.DTO.ChatDto;
import com.example.reactivechatapp.repository.ChatRepository;
import com.example.reactivechatapp.service.ChatService;
import com.example.reactivechatapp.domain.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;
    private final ChatRepository chatRepository;


    @CrossOrigin
    @GetMapping(value = "sender/{sender}/receiver/{receiver}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getMsg(@PathVariable String sender, @PathVariable String receiver){
        return  chatRepository.rFindBySender(sender, receiver)
                .subscribeOn(Schedulers.boundedElastic()); // Flux 타입 리턴
    }

    // 귓속말 기능 보류

    @CrossOrigin
    @PostMapping("/chat")
    public Mono<Chat> setMsg(@RequestBody ChatDto chatDto){
        return chatService.saveChat(chatDto);
    }


    // SSE
    @CrossOrigin
    @GetMapping(value = "/workspaces/{workSpaceId}/chatrooms/{chatRoomName}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> chatAPI(@PathVariable Long workSpaceId, @PathVariable String chatRoomName ){
        return chatService.slidedChat(workSpaceId, chatRoomName);
    }





}
