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
 *  邮件工具类
 *  2009-11-17
 */
public class MailSenderUtil {
	
	
	public static void main(String[] args) {

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
		mailInfo.setUserName("jiangzhiqiang@madeinchina-inc.com");
		mailInfo.setPassword("123456");
		String email = userBean.getEmail();
		mailInfo.setContent(userBean.getUserName() + "，你好，用户注册邮件测试" + userBean.getValidateCode());
		mailInfo.setFromAddress("jiangzhiqiang@madeinchina-inc.com");
		mailInfo.setSubject("用户注册邮件测试");
		mailInfo.setToAddress(email);
		mailInfo.setValidate(true);
		mailInfo.setMailServerHost("mail.madeinchina-inc.com");
		
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
		mailInfo.setUserName("jiangzhiqiang@madeinchina-inc.com");
		mailInfo.setPassword("123456");
		String email = userBean.getEmail();
		mailInfo.setContent(userBean.getUserName() + "，你好，您的密码是：" + userBean.getPassword() + "，请妥善保存。");
		mailInfo.setFromAddress("jiangzhiqiang@madeinchina-inc.com");
		mailInfo.setSubject("用户找回密码邮件测试");
		mailInfo.setToAddress(email);
		mailInfo.setValidate(true);
		mailInfo.setMailServerHost("mail.madeinchina-inc.com");
		
		return sendMail(mailInfo);
	}

}
