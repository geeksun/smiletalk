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
 *  �ʼ�������
 *  2009-11-17
 */
public class MailSenderUtil {
	
	
	public static void main(String[] args) {

	}

	/**
	 * �����ʼ�
	 * @param mailInfo
	 */
	private static int sendMail(MailInfo mailInfo) {
		// �ж��Ƿ���Ҫ�����֤    
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// �����Ҫ�����֤���򴴽�һ��������֤��    
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session    
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
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
			return 1;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	

	/**
	 * �����û������ʼ�
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
		mailInfo.setContent(userBean.getUserName() + "����ã��û�ע���ʼ�����" + userBean.getValidateCode());
		mailInfo.setFromAddress("jiangzhiqiang@madeinchina-inc.com");
		mailInfo.setSubject("�û�ע���ʼ�����");
		mailInfo.setToAddress(email);
		mailInfo.setValidate(true);
		mailInfo.setMailServerHost("mail.madeinchina-inc.com");
		
		return sendMail(mailInfo);
	}

	/**
	 *  �����û��һ������ʼ�
	 */
	public static int sendForgetDisposeEmail(UserBean userBean) {
		if(userBean==null){
			return 0;
		}
		MailInfo mailInfo = new MailInfo();
		mailInfo.setUserName("jiangzhiqiang@madeinchina-inc.com");
		mailInfo.setPassword("123456");
		String email = userBean.getEmail();
		mailInfo.setContent(userBean.getUserName() + "����ã����������ǣ�" + userBean.getPassword() + "�������Ʊ��档");
		mailInfo.setFromAddress("jiangzhiqiang@madeinchina-inc.com");
		mailInfo.setSubject("�û��һ������ʼ�����");
		mailInfo.setToAddress(email);
		mailInfo.setValidate(true);
		mailInfo.setMailServerHost("mail.madeinchina-inc.com");
		
		return sendMail(mailInfo);
	}

}
