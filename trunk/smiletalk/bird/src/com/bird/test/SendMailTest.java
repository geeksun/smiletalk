package com.bird.test;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 * @author jzq
 *  ���ʼ����ԣ���Ҫ��Ҫmail,avaction.jar
 */
public class SendMailTest {
	
	

	/**
	 * @param args
	 * @throws MessagingException 
	 */
	public static void main(String[] args) throws MessagingException {
		Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");	//�ʼ�����Э���еĽ���Э��
        props.setProperty("mail.smtp.auth", "true");	//�Ƿ�ͨ����֤:һ��Ϊtrue, false����ͨ����֤
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        msg.setText("user����ã��û�ע���ʼ�����");	//�ʼ�����
        msg.setFrom(new InternetAddress("jiangzhiqiang@madeinchina-inc.com"));	//�����ʼ���ַ
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress("jzq9899@163.com"));	//�����ʼ���ַ
        msg.setSubject("�û�ע���ʼ�����");  //�ʼ�����
        Transport transport = session.getTransport();
        transport.connect("mail.madeinchina-inc.com", 25, "jiangzhiqiang@madeinchina-inc.com", "123456");//�ʼ�������
        transport.sendMessage(msg, new Address[] { new InternetAddress("jzq9899@163.com")});
        transport.close();
	}
	

}
