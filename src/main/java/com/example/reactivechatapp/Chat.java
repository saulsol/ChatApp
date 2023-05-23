package com.example.reactivechatapp;


import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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

    private String workSpaceName;

    private String roomName; // 방 이름

    private LocalDateTime createdAt;


}
