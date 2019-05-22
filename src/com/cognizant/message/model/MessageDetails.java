package com.cognizant.message.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class MessageDetails {

	public MessageDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="m_id")
	private int mid;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="from_id")
	private UserDetails fromid;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="to_id")
	private UserDetails toid;
	
	@Column(name="message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageDetails [mid=" + mid + ", fromid=" + fromid + ", toid=" + toid + ", message=" + message + "]";
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public UserDetails getFromid() {
		return fromid;
	}

	public void setFromid(UserDetails fromid) {
		this.fromid = fromid;
	}

	public UserDetails getToid() {
		return toid;
	}

	public void setToid(UserDetails toid) {
		this.toid = toid;
	}

	

}
