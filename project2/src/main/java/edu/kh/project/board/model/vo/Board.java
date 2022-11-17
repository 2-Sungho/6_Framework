package edu.kh.project.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Board {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardCreateDate;
	private String boardUpdateDate;
	private int readCount;
	private int commentCount;
	private int likeCount;
	private String memberNickname;
	private int memberNo;
	private String profileImage;
	private String thumbnail;

}
