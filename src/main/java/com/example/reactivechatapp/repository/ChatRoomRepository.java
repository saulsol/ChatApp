package com.example.reactivechatapp.repository;


import com.example.reactivechatapp.domain.ChatRoom;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

import java.util.List;


public interface ChatRoomRepository extends ReactiveMongoRepository<ChatRoom, String> {


   Flux<ChatRoom> findAllByWorkSpaceId(Long workSpaceId); // 워크스페이스 ID를 받으면 채팅방 리스트를 전부 넘김


}
