package com.example.reactivechatapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@RestController // 데이터 리턴 서버
@RequiredArgsConstructor
public class ChatController {

    private final ChatRepository chatRepository;

    @CrossOrigin
    @GetMapping(value = "sender/{sender}/receiver/{receiver}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getMsg(@PathVariable String sender, @PathVariable String receiver){
        return  chatRepository.mFindBySender(sender, receiver)
                .subscribeOn(Schedulers.boundedElastic()); // Flux 타입 리턴
    }

    @CrossOrigin
    @PostMapping("/chat")
    public Mono<Chat> setMsg(@RequestBody Chat chat){ // Mono는 데이터를 한 번만 리턴한다는 것
        chat.setCreatedAt(LocalDateTime.now());

        return chatRepository.save(chat);
    }


    @CrossOrigin
    @GetMapping(value = "/app/chats/chatrooms/{roomNum}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> findByRoomNum(@PathVariable Integer roomNum){

        return chatRepository.mFindByRoomNum(roomNum)
                .subscribeOn(Schedulers.boundedElastic());
    }





}
