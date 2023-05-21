package com.example.reactivechatapp;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

    @Tailable // 계속 데이터를 흘려 보낸다(Flux 로)
    @Query("{'sender' : ?0, 'receiver' : ?1}")
    Flux<Chat> mFindBySender(String sender, String receiver);


    @Tailable
    @Query("{'roomNum': ?0}") // 방 단위로 조회하게 됨
    Flux<Chat> mFindByRoomNum(Integer roomNum);

}
