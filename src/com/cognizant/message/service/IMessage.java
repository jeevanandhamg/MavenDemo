package com.cognizant.message.service;

import java.util.List;

import com.cognizant.message.model.MessageDetails;
import com.cognizant.message.model.UserDetails;

public interface IMessage {

	public int connect(UserDetails ud);
	public List<UserDetails> getUserDetails(int uid);
	public List<MessageDetails> getMessages(int fromid,int toid);
	public void sendMessage(MessageDetails md,int fromid,int toid,String msg);
	
}
