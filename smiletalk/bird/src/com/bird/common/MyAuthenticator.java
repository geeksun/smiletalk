package com.bird.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**   
 * 简单邮件（不带附件的邮件）发送器
 * author: jzq
 * 2009-11-17
 */    
public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    
    /**
     * 邮件服务器的用户名、密码
     * @param username
     * @param password
     */
    public MyAuthenticator(String username, String password) {
        this.userName = username;    
        this.password = password;    
    }    
    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }
    
}   
