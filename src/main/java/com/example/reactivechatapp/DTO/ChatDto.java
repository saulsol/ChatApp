package com.example.reactivechatapp.DTO;

import com.example.reactivechatapp.ReceiverType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Builder
public class ChatDto {

    private String msg;

    private String sender; // 보내는 사람

    private ReceiverType receiver; // 받는 사람[방 전체, 개인]

    private String workSpaceName;

    private String roomName; // 방 번호

}
