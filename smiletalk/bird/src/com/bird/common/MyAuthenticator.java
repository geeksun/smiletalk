package com.bird.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**   
 * ���ʼ��������������ʼ���������
 * author: jzq
 * 2009-11-17
 */    
public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    
    /**
     * �ʼ����������û���������
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
