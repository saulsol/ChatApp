package com.example.reactivechatapp.service;

import com.example.reactivechatapp.DTO.CreateChatRoomDto;
import com.example.reactivechatapp.domain.ChatRoom;
import com.example.reactivechatapp.repository.ChatRepository;
import com.example.reactivechatapp.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRepository chatRepository;

    // 유저가 방 생성
    public Mono<ChatRoom> createChatRoom(CreateChatRoomDto createChatRoomDto){

        ChatRoom newChatRoom = ChatRoom.builder()
                .workSpaceId(createChatRoomDto.getWorkSpaceId())
                .workSpaceName(createChatRoomDto.getWorkSpaceName())
                .chatRoomName(createChatRoomDto.getChatRoomName())
                .ChatRoomNumOfPeople(createChatRoomDto.getChatRoomNumOfPeople())
                .memberList(createChatRoomDto.getMemberList())
                .createdBy(createChatRoomDto.getCreatedBy())
                .build();

        return chatRoomRepository.save(newChatRoom); // 생성된 채팅방 리턴
    }

    // 유저가 채팅방을 나간 경우 -> 채팅방 인원수 -1, 채팅방 유저리스트 '해당 유저 제거'



    // 유저가 채팅방 합류 -> 채팅방 인원수 +1, 채팅방 유저리스트 '해당 유저 추가'

    // 채팅방의 유저 인원수가 0 -> 해당 채팅방 삭제, 채팅 로그 해당 채팅방과 관련있는 채팅 로그 전부 삭제

    // 워크 스페이스 삭제 -> 워크 스페이스랑 관련있는 모든 채팅방 삭제, 채팅 로그 삭제
}
