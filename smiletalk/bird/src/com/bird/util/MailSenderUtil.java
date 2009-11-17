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
 *  邮件工具类
 *  2009-11-17
 */
public class MailSenderUtil {
	
	/**
	 * 以文本格式发送邮件   
	 * @param mailInfo 待发送的邮件的信息   
	 */
	public boolean sendTextMail(MailInfo mailInfo) {
		// 判断是否需要身份认证    
		MyAuthenticator authenticator = null;
		Properties prop = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器    
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session    
		Session sendMailSession = Session
				.getDefaultInstance(prop, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址    
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者    
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中    
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题    
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间    
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内容    
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);
			// 发送邮件    
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/** */
	/**   
	 * 以HTML格式发送邮件   
	 * @param mailInfo 待发送的邮件信息   
	 */
	public static boolean sendHtmlMail(MailInfo mailInfo) {
		// 判断是否需要身份认证    
		MyAuthenticator authenticator = null;
		Properties prop = mailInfo.getProperties();
		//如果需要身份认证，则创建一个密码验证器     
		if (mailInfo.isValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session    
		Session sendMailSession = Session
				.getDefaultInstance(prop, authenticator);
		try {
			// 根据session创建一个邮件消息    
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址    
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者    
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中    
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO属性表示接收者的类型为TO    
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题    
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间    
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象    
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart    
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容    
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件    
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 发送用户激活邮件
	 * @param userBean
	 * @throws MessagingException
	 */
	public static void sendActivateEmail(UserBean userBean) throws MessagingException {
		Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");	//邮件传输协议中的接收协议
        props.setProperty("mail.smtp.auth", "true");	//是否通过验证:一般为true, false不能通过验证
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        msg.setText(userBean.getUserName() + "，你好，用户注册邮件测试");	//邮件内容
        msg.setFrom(new InternetAddress("jiangzhiqiang@madeinchina-inc.com"));	//发送邮件地址
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(userBean.getEmail()));	//接受邮件地址
        msg.setSubject("用户注册邮件测试");  //邮件主题
        Transport transport = session.getTransport();
        transport.connect("mail.madeinchina-inc.com", 25, "jiangzhiqiang@madeinchina-inc.com", "123456");//邮件服务器
        transport.sendMessage(msg, new Address[] { new InternetAddress(userBean.getEmail())});
        transport.close();		
        
        MailInfo mailInfo = new MailInfo();
        mailInfo.setContent(userBean.getUserName() + "，你好，用户注册邮件测试");
        mailInfo.setFromAddress("jiangzhiqiang@madeinchina-inc.com");
        mailInfo.setSubject("用户注册邮件测试");
        mailInfo.setToAddress(userBean.getEmail());
        
        
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	}

	
}
