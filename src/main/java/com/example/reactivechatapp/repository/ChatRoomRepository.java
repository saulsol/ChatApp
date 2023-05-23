package com.example.reactivechatapp.repository;


import com.example.reactivechatapp.domain.ChatRoom;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ChatRoomRepository extends ReactiveMongoRepository<ChatRoom, String> {



}
