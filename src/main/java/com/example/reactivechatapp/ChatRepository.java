package com.example.reactivechatapp;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

    @Tailable
    @Query("{'sender' : ?0, 'receiver' : ?1}")
    Flux<Chat> rFindBySender(String sender, String receiver);


    @Tailable
    @Query("{'workSpaceName': ?0, 'roomName': ?1}") // 워크 스페이스, 방 단위로 조회하게 됨
    Flux<Chat> rFindByWorkspaceIdAndRoomName(String workspaceName, String roomName);

}
