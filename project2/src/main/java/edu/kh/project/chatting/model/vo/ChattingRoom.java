package edu.kh.project.chatting.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ChattingRoom {

	private int chattingNo;
    private String lastMessage;
    private String sendTime;
    private int targetNo;
    private String targetNickName;
    private String targetProfile;
    private int notReadCount;
}
