package com.example.reactivechatapp.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Document(collection = "chatroom")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatRoom {

    @Id
    private Long roomId;

    //워크스페이스 이름
    private Long workSpaceId;

    private String workSpaceName;

    // 채팅방 이름
    private String chatRoomName;

    // 채팅방 인원 수 -> 인원수가 0명이 되면 채팅방 자연 삭제
    private Long ChatRoomNumOfPeople;

    // 채팅방 인원 리스트
    private List<String> memberList = new ArrayList<>();

    // 채팅방을 만든 사람 -> 삭제권한 소유
    private String createdBy;


    public void joinTheChatRoom(){

    }


}
