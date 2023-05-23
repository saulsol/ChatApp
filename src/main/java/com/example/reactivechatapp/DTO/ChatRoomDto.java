package com.example.reactivechatapp.DTO;


import lombok.Builder;
import lombok.Data;


import java.util.List;


@Data
@Builder
public class ChatRoomDto {

    private String chatRoomName;

    private Long ChatRoomNumOfPeople;

    private List<String> memberList;
}
