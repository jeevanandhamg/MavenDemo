package com.cognizant.message.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.cognizant.message.model.MessageDetails;
import com.cognizant.message.model.UserDetails;
import com.cognizant.message.service.IMessage;

@Component
public class MessageDAO implements IMessage {

	public MessageDAO() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	public EntityManager entityManager;

	public int connect(UserDetails lv) {
		// TODO Auto-generated method stub

		int flag = 0;
		System.out.println("LV :" + lv);
		String hql = "Select l.uname,l.pass,l.id from UserDetails l where l.uname=? and l.pass=?";
		Query query = entityManager.createQuery(hql);
		query.setParameter(0, lv.getUname());
		query.setParameter(1, lv.getPass());

		// System.out.println("Resuklt"+query.getSingleResult());
		List<Object[]> l = query.getResultList();

		if (!l.isEmpty()) {
			System.out.println("List Values :" + l.get(0));
			Object un = l.get(0)[0];
			Object pas = l.get(0)[1];
			lv.setId((int) l.get(0)[2]);
			if (un != null && pas != null) {
				System.out.println("Logged in");
				flag = lv.getId();
			} else {
				System.out.println("User not available");
			}
		}

		// entityManager.close();
		return flag;

	}

	@Override
	public List<UserDetails> getUserDetails(int uid) {
		// TODO Auto-generated method stub
		System.out.println("uid = " + uid);
		List<UserDetails> li = new ArrayList<UserDetails>();
		String hql = "Select l from UserDetails l where l.id!=?";
		TypedQuery<UserDetails> query = entityManager.createQuery(hql, UserDetails.class);
		query.setParameter(0, uid);
		li = query.getResultList();

		return li;

	}

	@Override
	public List<MessageDetails> getMessages(int fromid, int toid) {
		// TODO Auto-generated method stub
		UserDetails ud0 = new UserDetails();
		ud0.setId(fromid);
		List<MessageDetails> li = new ArrayList<MessageDetails>();
		String hql = "Select l from MessageDetails l where (l.fromid=? AND l.toid=?) OR (l.fromid=? AND l.toid=?)";
		TypedQuery<MessageDetails> query = entityManager.createQuery(hql, MessageDetails.class);
		query.setParameter(0, ud0);
		query.setParameter(3, ud0);
		UserDetails ud1 = new UserDetails();
		ud1.setId(toid);
		query.setParameter(1, ud1);
		query.setParameter(2, ud1);
		li = query.getResultList();
		return li;
	}

	@Transactional
	@Override
	public void sendMessage(MessageDetails md, int fromid, int toid, String msg) {
		// TODO Auto-generated method stub
		UserDetails ud0 = new UserDetails();
		ud0.setId(fromid);

		UserDetails ud1 = new UserDetails();
		ud1.setId(toid);

		md.setFromid(ud0);
		md.setToid(ud1);
		md.setMessage(msg);
		entityManager.persist(md);

	}

}
