package com.cognizant.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.message.model.MessageDetails;
import com.cognizant.message.model.UserDetails;

@Service(value = "messageService")
public class MessageService implements IMessage {

	public MessageService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	IMessage messageDAO;

	public int connect(UserDetails ud) {
		// TODO Auto-generated method stub
		return messageDAO.connect(ud);
	}

	@Override
	public List<UserDetails> getUserDetails(int uid) {
		// TODO Auto-generated method stub
		return messageDAO.getUserDetails(uid);
	}

	@Override
	public List<MessageDetails> getMessages(int fromid, int toid) {
		// TODO Auto-generated method stub
		return messageDAO.getMessages(fromid, toid);
	}

	@Override
	public void sendMessage(MessageDetails md, int fromid, int toid, String msg) {
		// TODO Auto-generated method stub
		messageDAO.sendMessage(md, fromid, toid, msg);
	}

}
