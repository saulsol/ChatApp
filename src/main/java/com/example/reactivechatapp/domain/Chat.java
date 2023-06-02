package com.example.reactivechatapp.domain;


import com.example.reactivechatapp.ReceiverType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Builder
@Document(collection = "chat")
public class Chat {
    @Id
    private String id;

    private String msg;

    private String sender; // 보내는 사람

    private ReceiverType receiver; // 받는 사람(방 이름)

    private Long workSpaceId; // 워크스페이스 ID

    private String chatRoomName; // 방 이름

    private LocalDateTime createdAt;


}
