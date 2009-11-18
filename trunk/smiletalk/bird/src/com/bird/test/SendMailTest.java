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
 *  发邮件测试，需要需要mail,avaction.jar
 */
public class SendMailTest {
	
	

	/**
	 * @param args
	 * @throws MessagingException 
	 */
	public static void main(String[] args) throws MessagingException {
		Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");	//邮件传输协议中的接收协议
        props.setProperty("mail.smtp.auth", "true");	//是否通过验证:一般为true, false不能通过验证
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        msg.setText("user，你好，用户注册邮件测试");	//邮件内容
        msg.setFrom(new InternetAddress("jiangzhiqiang@madeinchina-inc.com"));	//发送邮件地址
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress("jzq9899@163.com"));	//接受邮件地址
        msg.setSubject("用户注册邮件测试");  //邮件主题
        Transport transport = session.getTransport();
        transport.connect("mail.madeinchina-inc.com", 25, "jiangzhiqiang@madeinchina-inc.com", "123456");//邮件服务器
        transport.sendMessage(msg, new Address[] { new InternetAddress("jzq9899@163.com")});
        transport.close();
	}
	

}
