package com.bird.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.bird.common.MyAuthenticator;
import com.bird.domain.UserBean;
import com.bird.po.MailInfo;

/**
 * @author jzq
 *  邮件工具类: 支持SMTP协议
 *  SMTP 的全称是“Simple Mail Transfer Protocol”，即简单邮件传输协议。它是一组用于从源地址到目的地址传输邮件的规范，通过它来控制邮件的中转方式。
 *  SMTP 协议属于 TCP/IP 协议簇，它帮助每台计算机在发送或中转信件时找到下一个目的地。SMTP 服务器就是遵循 SMTP 协议的发送邮件服务器。 
 *　SMTP 认证，简单地说就是要求必须在提供了账户名和密码之后才可以登录 SMTP 服务器，这就使得那些垃圾邮件的散播者无可乘之机。 
 *　增加 SMTP 认证的目的是为了使用户避免受到垃圾邮件的侵扰。
 *  2009-11-17
 */
public class MailSenderUtil {
	/** 邮件服务器  */
	private static String MAIL_SERVER_HOST= "smtp.163.com";
	
	public static void main(String[] args) {
		MailInfo mailInfo = new MailInfo();
		mailInfo.setUserName("geeksun@163.com");
		mailInfo.setPassword("geeksun19");
		String email = "330896202@qq.com";
		mailInfo.setContent("test，你好，用户注册邮件测试" );
		mailInfo.setFromAddress("geeksun@163.com");
		mailInfo.setSubject("用户注册邮件测试");
		mailInfo.setToAddress(email);
		mailInfo.setValidate(true);
		mailInfo.setMailServerHost(MAIL_SERVER_HOST);
		sendMail(mailInfo);
	}

	/**
	 * 发送邮件
	 * @param mailInfo
	 */
	private static int sendMail(MailInfo mailInfo) {
		// 判断是否需要身份认证    
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器    
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session    
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
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
			return 1;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	

	/**
	 * 发送用户激活邮件
	 */
	public static int sendActivateEmail(UserBean userBean)
			throws MessagingException {
		if(userBean==null){
			return 0;
		}
		MailInfo mailInfo = new MailInfo();
		mailInfo.setUserName("geeksun@163.com");
		mailInfo.setPassword("geeksun19");
		String email = userBean.getEmail();
		mailInfo.setContent(userBean.getUserName() + "，你好，用户注册邮件测试" + userBean.getValidateCode());
		mailInfo.setFromAddress("geeksun@163.com");
		mailInfo.setSubject("用户注册邮件测试");
		mailInfo.setToAddress(email);
		mailInfo.setValidate(true);
		mailInfo.setMailServerHost(MAIL_SERVER_HOST);
		
		return sendMail(mailInfo);
	}

	/**
	 *  发送用户找回密码邮件
	 */
	public static int sendForgetDisposeEmail(UserBean userBean) {
		if(userBean==null){
			return 0;
		}
		MailInfo mailInfo = new MailInfo();
		mailInfo.setUserName("geeksun@163.com");
		mailInfo.setPassword("geeksun19");
		String email = userBean.getEmail();
		mailInfo.setContent(userBean.getUserName() + "，你好，您的密码是：" + userBean.getPassword() + "，请记住");
		mailInfo.setFromAddress("geeksun@163.com");
		mailInfo.setSubject("用户找回密码邮件测试");
		mailInfo.setToAddress(email);
		mailInfo.setValidate(true);
		mailInfo.setMailServerHost(MAIL_SERVER_HOST);
		
		return sendMail(mailInfo);
	}

}
