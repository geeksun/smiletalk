package com.bird.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.bird.common.MyAuthenticator;
import com.bird.domain.MailInfo;
import com.bird.domain.UserBean;

/**
 * @author jzq
 *  �ʼ�������
 *  2009-11-17
 */
public class MailSenderUtil {
	
	/**
	 * ���ı���ʽ�����ʼ�   
	 * @param mailInfo �����͵��ʼ�����Ϣ   
	 */
	public boolean sendTextMail(MailInfo mailInfo) {
		// �ж��Ƿ���Ҫ�����֤    
		MyAuthenticator authenticator = null;
		Properties prop = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// �����Ҫ�����֤���򴴽�һ��������֤��    
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session    
		Session sendMailSession = Session
				.getDefaultInstance(prop, authenticator);
		try {
			// ����session����һ���ʼ���Ϣ
			Message mailMessage = new MimeMessage(sendMailSession);
			// �����ʼ������ߵ�ַ    
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// �����ʼ���Ϣ�ķ�����    
			mailMessage.setFrom(from);
			// �����ʼ��Ľ����ߵ�ַ�������õ��ʼ���Ϣ��    
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// �����ʼ���Ϣ������    
			mailMessage.setSubject(mailInfo.getSubject());
			// �����ʼ���Ϣ���͵�ʱ��    
			mailMessage.setSentDate(new Date());
			// �����ʼ���Ϣ����Ҫ����    
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);
			// �����ʼ�    
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/** */
	/**   
	 * ��HTML��ʽ�����ʼ�   
	 * @param mailInfo �����͵��ʼ���Ϣ   
	 */
	public static boolean sendHtmlMail(MailInfo mailInfo) {
		// �ж��Ƿ���Ҫ�����֤    
		MyAuthenticator authenticator = null;
		Properties prop = mailInfo.getProperties();
		//�����Ҫ�����֤���򴴽�һ��������֤��     
		if (mailInfo.isValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session    
		Session sendMailSession = Session
				.getDefaultInstance(prop, authenticator);
		try {
			// ����session����һ���ʼ���Ϣ    
			Message mailMessage = new MimeMessage(sendMailSession);
			// �����ʼ������ߵ�ַ    
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// �����ʼ���Ϣ�ķ�����    
			mailMessage.setFrom(from);
			// �����ʼ��Ľ����ߵ�ַ�������õ��ʼ���Ϣ��    
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO���Ա�ʾ�����ߵ�����ΪTO    
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// �����ʼ���Ϣ������    
			mailMessage.setSubject(mailInfo.getSubject());
			// �����ʼ���Ϣ���͵�ʱ��    
			mailMessage.setSentDate(new Date());
			// MiniMultipart����һ�������࣬����MimeBodyPart���͵Ķ���    
			Multipart mainPart = new MimeMultipart();
			// ����һ������HTML���ݵ�MimeBodyPart    
			BodyPart html = new MimeBodyPart();
			// ����HTML����    
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// ��MiniMultipart��������Ϊ�ʼ�����
			mailMessage.setContent(mainPart);
			// �����ʼ�    
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * �����û������ʼ�
	 * @param userBean
	 * @throws MessagingException
	 */
	public static void sendActivateEmail(UserBean userBean) throws MessagingException {
		Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");	//�ʼ�����Э���еĽ���Э��
        props.setProperty("mail.smtp.auth", "true");	//�Ƿ�ͨ����֤:һ��Ϊtrue, false����ͨ����֤
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        msg.setText(userBean.getUserName() + "����ã��û�ע���ʼ�����");	//�ʼ�����
        msg.setFrom(new InternetAddress("jiangzhiqiang@madeinchina-inc.com"));	//�����ʼ���ַ
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(userBean.getEmail()));	//�����ʼ���ַ
        msg.setSubject("�û�ע���ʼ�����");  //�ʼ�����
        Transport transport = session.getTransport();
        transport.connect("mail.madeinchina-inc.com", 25, "jiangzhiqiang@madeinchina-inc.com", "123456");//�ʼ�������
        transport.sendMessage(msg, new Address[] { new InternetAddress(userBean.getEmail())});
        transport.close();		
        
        MailInfo mailInfo = new MailInfo();
        mailInfo.setContent(userBean.getUserName() + "����ã��û�ע���ʼ�����");
        mailInfo.setFromAddress("jiangzhiqiang@madeinchina-inc.com");
        mailInfo.setSubject("�û�ע���ʼ�����");
        mailInfo.setToAddress(userBean.getEmail());
        
        
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	}

	
}
