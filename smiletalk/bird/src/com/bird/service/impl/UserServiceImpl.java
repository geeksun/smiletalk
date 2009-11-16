package com.bird.service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bird.domain.UserBean;
import com.bird.service.SuperService;
import com.bird.service.UserService;

public class UserServiceImpl extends SuperService implements UserService {

	public int deleteObject(Object o) {
		return 0;
	}

	public Object getObject(Object o) {
		return getUserDao().getObject(o);
	}

	public List<UserBean> getObjectList(Object o) {
		return null;
	}

	public int insertObject(Object o) {
		return getUserDao().insertObject(o);
	}

	public UserBean loginUser(UserBean userBean) {
		return getUserDao().loginUser(userBean);
	}

	/**
	 *  �����û������ʼ�
	 */
	public void sendActivateEmail(UserBean userBean) throws MessagingException {
		if(userBean==null){
			return;
		}
		Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");//�ʼ�����Э���еĽ���Э��
        props.setProperty("mail.smtp.auth", "true");//�Ƿ�ͨ����֤:һ��Ϊtrue, false����ͨ����֤
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        msg.setText(userBean.getUserName() + "����ã��û�ע���ʼ�����");	//�ʼ�����
        msg.setFrom(new InternetAddress("jiangzhiqiang@madeinchina-inc.com"));	//�����ʼ���ַ
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(userBean.getEmail()));	//�����ʼ���ַ
        msg.setSubject("�û�ע���ʼ�����");  //�ʼ�����
        Transport transport = session.getTransport();
        transport.connect("mail.madeinchina-inc.com", 25, "jiangzhiqiang@madeinchina-inc.com", "123456");//�ʼ�������
        transport.sendMessage(msg, new Address[] { new InternetAddress(
                userBean.getEmail()) });
        transport.close();
	}
	

}
