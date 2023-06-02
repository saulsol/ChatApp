package com.example.reactivechatapp.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindAllChatRoomsDto {

    private Long workSpaceId;
}
