package com.example.reactivechatapp.DTO;


import lombok.Builder;
import lombok.Data;


import java.util.List;


@Data
@Builder
public class CreateChatRoomDto {

    private Long workSpaceId;

    private String workSpaceName;

    private String chatRoomName;

    private Long ChatRoomNumOfPeople;

    private List<String> memberList;

    private String createdBy;

}
