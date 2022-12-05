package edu.kh.project.chatting.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.chatting.model.dao.ChattingDAO;
import edu.kh.project.chatting.model.vo.ChattingRoom;
import edu.kh.project.chatting.model.vo.Message;
import edu.kh.project.common.Util;

@Service
public class ChattingServiceImpl implements ChattingService {

	@Autowired
	private ChattingDAO dao;

	@Override
	public int checkChattingNo(Map<String, Integer> map) {
		return dao.checkChattingNo(map);
	}

	@Override
	public int createChattingRoom(Map<String, Integer> map) {
		return dao.createChattingRoom(map);
	}

	@Override
	public List<ChattingRoom> selectRoomList(int memberNo) {
		return dao.selectRoomList(memberNo);
	}


	@Override
	public int insertMessage(Message msg) {
//	        msg.setMessageContent(Util.XSSHandling(msg.getMessageContent()));
		msg.setMessageContent(Util.newLineHandling(msg.getMessageContent()));
		return dao.insertMessage(msg);
	}

	@Override
	public int updateReadFlag(Map<String, Object> paramMap) {
		return dao.updateReadFlag(paramMap);
	}

	@Override
	public List<Message> selectMessageList(Map<String, Object> paramMap) {
		System.out.println(paramMap);
		List<Message> messageList = dao.selectMessageList(Integer.parseInt(String.valueOf(paramMap.get("chattingNo"))));

		if (!messageList.isEmpty()) {
			int result = dao.updateReadFlag(paramMap);
		}
		return messageList;
	}
}
