package com.example.reactivechatapp.domain;


import com.example.reactivechatapp.ReceiverType;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Builder
@Document(collection = "chat")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Chat {
    @Id
    private Long id;

    private String msg;

    private String sender; // 보내는 사람

    private ReceiverType receiver; // 받는 사람(방 이름)

    private String workSpaceName;

    private String roomName; // 방 이름

    private LocalDateTime createdAt;


}
