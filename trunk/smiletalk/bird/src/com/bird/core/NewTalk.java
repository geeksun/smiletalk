package com.bird.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bird.db.DataBaseUtil;
import com.bird.util.DateUtil;
import com.bird.util.MD5;
import com.bird.vo.TopicBean;
import com.bird.vo.UserBean;

/**
 * @author jzq
 *  beta 0.1
 *  2009-11-9
 */
public class NewTalk extends HttpServlet{
	
	public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
		throws javax.servlet.ServletException, java.io.IOException{
		return;
	}
	
	public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
		throws javax.servlet.ServletException, java.io.IOException{
		request.setCharacterEncoding("GBK");
		HttpSession session = request.getSession(true);
		
		String iTalkAct = request.getParameter("iTalkAct");		//iTalk �Ķ������
		String action = request.getParameter("action");
		
		if(iTalkAct!=null){
			if(iTalkAct.equals("iTalkTopic")&&!"ins".equals(action)){					//talk topic-����
				Long userid = (Long) session.getAttribute("userid");
				Connection con = DataBaseUtil.getConnection();
				
				// �õ�����formhash
			    String formhash = request.getParameter("formhash");
			    // �õ�session����ļ���
			    Set<String> formhashSession = (Set<String>) session.getAttribute("formhashSession");
			    // ���û�У������ظ��ύ�����߷Ƿ��ύ
			    if (formhashSession == null || !formhashSession.contains(formhash)) {
				      System.out.println("�벻Ҫ�ظ��ύ��");
				      //return;
			    }else{
			    	String talkTopic = request.getParameter("talkTopic");
			    	String username = (String) session.getAttribute("username");
					String exe_sql = "insert topic (username,topicContent,userid,topicTime) values (?,?,?,?)";
					try {
						PreparedStatement pst = con.prepareStatement(exe_sql);
						pst.setString(1, username);
						pst.setString(2, talkTopic);
						pst.setLong(3, userid);
						Date d = new Date();
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String topicTime = df.format(d);
						pst.setString(4,  topicTime);
						pst.execute();
					} catch (SQLException e) {
							try {
								con.rollback();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						e.printStackTrace();
					}
			    }
			    
				String next_sql = "select * from topic t where t.userid = ?";
				try {
					PreparedStatement pst = con.prepareStatement(next_sql);
					pst.setLong(1, userid);
					ResultSet rs = pst.executeQuery();
					List<TopicBean> topicList = new ArrayList<TopicBean>();
					TopicBean tbean = null;
					while(rs.next()){
						tbean = new TopicBean();
						tbean.setUsername(rs.getString("username"));
						tbean.setTopicContent(rs.getString("topicContent"));
						tbean.setTopicTime(rs.getString("topicTime"));
						topicList.add(tbean);
					}
					request.setAttribute("topicList", topicList);
					request.getRequestDispatcher("/frame/iTalk.jsp").forward(request, response);
					
					// ���,��������ɹ�,��session�������� formhash ɾ����
				    formhashSession.remove(formhash);
				    session.setAttribute("formhashSession", formhashSession);
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DataBaseUtil.closeConnection(con);
				}
			}else if(iTalkAct.equals("iTalkLogin")){				// login-��¼
				String iTalkName = request.getParameter("iTalkName");
				String iTalkpwd = request.getParameter("iTalkpwd");
				Connection con = DataBaseUtil.getConnection();
				String sql = "select * from user t where t.username=? and t.password=?";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(sql);
					pst.setString(1, iTalkName);
					pst.setString(2, iTalkpwd);
					//System.out.println(sql);
					ResultSet rs = pst.executeQuery();
					List<UserBean> userList = new ArrayList<UserBean>();
					UserBean ubean = null;
					while(rs.next()) {
						ubean = new UserBean();
						ubean.setUserId(rs.getLong("userId"));
						ubean.setUsername(rs.getString("username"));
						userList.add(ubean);
					}
					if(userList.size()>0){
						ubean = userList.get(0);
						session.setAttribute("username", ubean.getUsername());
						long userid = ubean.getUserId();
						session.setAttribute("userid", userid);
						
						String next_sql = "select * from topic t where t.userid = ?";
						try {
							pst = con.prepareStatement(next_sql);
							pst.setLong(1, userid);
							rs = pst.executeQuery();			//preparedStatement��executeQuery������executeQuery(sql)!
							List<TopicBean> topicList = new ArrayList<TopicBean>();
							TopicBean tbean = null;
							while(rs.next()) {
								tbean = new TopicBean();
								tbean.setUsername(rs.getString("username"));
								tbean.setTopicContent(rs.getString("topicContent"));
								tbean.setTopicTime(rs.getString("topicTime"));
								topicList.add(tbean);
							}
							request.setAttribute("topicList", topicList);
							request.getRequestDispatcher("/frame/iTalk.jsp").forward(request, response);
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DataBaseUtil.closeConnection(con);
				}
			}else if(iTalkAct.equals("iTalkRegister")){						//register new user
				String iTalkName =  request.getParameter("iTalkName");
				String iTalkpwd =  request.getParameter("iTalkpwd");
				String iTalkemail =  request.getParameter("iTalkemail");
				Connection con = DataBaseUtil.getConnection();
				String exe_sql = "insert user (username,password,email,regTime) values (?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(exe_sql);
					pst.setString(1, iTalkName);
					pst.setString(2, iTalkpwd);
					pst.setString(3, iTalkemail);
					Date d = new Date();
					/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");*/
					String regTime = DateUtil.getDateString(d);
					pst.setString(4,  regTime);
					pst.execute();
				} catch (SQLException e) {
						try {
							con.rollback();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					e.printStackTrace();
				}finally{
					DataBaseUtil.closeConnection(con);
				}
				request.getRequestDispatcher("/frame/iTalk.jsp").forward(request, response);
			}
			
		}
		
		//System.out.println(talkTopic);
		
	}
	
	/**
	 * struts ���ƻ���
	 * @param request
	 * @return  ��������
	 */
	protected String generateToken(HttpServletRequest request) {
       HttpSession session = request.getSession();
       try {
           byte id[] = session.getId().getBytes();
           byte now[] = new Long(System.currentTimeMillis()).toString().getBytes();
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(id);
           md.update(now);
           return (toHex(md.digest()));
       } catch (IllegalStateException e) {
           return (null);
       } catch (NoSuchAlgorithmException e) {
           return (null);
       }
	}
	
	/**
	 * @param  buffer
	 * @return 16���Ƶ��ַ�����ʾ
	 */
	protected String toHex(byte buffer[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buffer.length; i++)
            sb.append(Integer.toHexString((int) buffer[i] & 0xff));
        return (sb.toString());
    }
	
	
}
