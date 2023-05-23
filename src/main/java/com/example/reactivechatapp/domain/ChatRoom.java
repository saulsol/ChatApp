package com.example.reactivechatapp.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Document(collection = "chatroom")
public class ChatRoom {

    @Id
    private Long roomId;

    // 채팅방 이름
    private String chatRoomName;

    // 채팅방 인원 수
    private Long ChatRoomNumOfPeople;

    // 채팅방 인원 리스트
    private List<String> memberList;



}
