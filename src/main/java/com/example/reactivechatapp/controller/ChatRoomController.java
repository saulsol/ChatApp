package com.example.reactivechatapp.controller;

import com.example.reactivechatapp.DTO.CreateChatRoomDto;
import com.example.reactivechatapp.domain.ChatRoom;
import com.example.reactivechatapp.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    // 채팅방 생성
    @CrossOrigin
    @PostMapping(value = "/chatRooms/create")
    public Mono<ChatRoom> createChatRoom(@RequestBody CreateChatRoomDto createChatRoomDto){
        return chatRoomService.createChatRoom(createChatRoomDto);
    }


    // 모든 채팅방 리턴
    @CrossOrigin
    @GetMapping(value = "/workspaces/{workSpaceId}/chatRooms", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatRoom> allChatRooms(@PathVariable Long workSpaceId) {
        return chatRoomService.slidedChatRooms(workSpaceId);
    }

}
