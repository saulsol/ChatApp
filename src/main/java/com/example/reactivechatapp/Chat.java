package com.example.reactivechatapp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "chat")
public class Chat {
    @Id
    private String id;

    private String msg;

    private String sender; // 보내는 사람
    
    private String receiver; // 받는 사람

    private LocalDateTime createdAt;


}
