package com.example.reactivechatapp.service;

import com.example.reactivechatapp.repository.ChatRepository;
import com.example.reactivechatapp.DTO.ChatDto;
import com.example.reactivechatapp.domain.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public Mono<Chat> saveChat(ChatDto chatDto){
        Chat newChat = createChat(chatDto);
        return chatRepository.save(newChat);
    }


    public Flux<Chat> slidedChat(String workspaceName, String chatroomName){

        return chatRepository
                .rFindByWorkspaceIdAndRoomName(workspaceName, chatroomName)
                .subscribeOn(Schedulers.boundedElastic());
    }


    private Chat createChat(ChatDto chatDto){
        return Chat.builder()
                .msg(chatDto.getMsg())
                .sender(chatDto.getSender())
                .receiver(chatDto.getReceiver())
                .workSpaceName(chatDto.getWorkSpaceName())
                .createdAt(LocalDateTime.now())
                .roomName(chatDto.getRoomName())
                .build();
    }
















}
