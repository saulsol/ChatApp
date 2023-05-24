package com.example.reactivechatapp.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JoinChatRoomDto {

    // 어떤 유저가 어떤 워크스페이스의 어떤 채팅방에 합류했는지
    private String workSpaceName;

    private String chatRoomName;

    private String userName;

}
