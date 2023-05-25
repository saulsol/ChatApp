package com.example.reactivechatapp.repository;

import com.example.reactivechatapp.domain.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

    @Tailable
    @Query("{'sender' : ?0, 'receiver' : ?1}")
    Flux<Chat> rFindBySender(String sender, String receiver);

    @Tailable
    @Query("{'workSpaceId': ?0, 'ChatRoomName': ?1}") // 워크 스페이스, 방 단위로 조회하게 됨
    Flux<Chat> rFindByWorkspaceIdAndRoomName(Long workSpaceId, String chatRoomName);



}
