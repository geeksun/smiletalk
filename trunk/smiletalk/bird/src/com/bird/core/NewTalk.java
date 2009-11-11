package com.bird.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bird.db.DataBaseUtil;
import com.bird.domain.TopicBean;
import com.bird.domain.UserBean;
import com.bird.service.TopicService;
import com.bird.service.impl.TopicServiceImpl;
import com.bird.util.DateUtil;

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
		
		String iTalkAct = request.getParameter("iTalkAct");		//iTalk 的动作标记
		
		if(iTalkAct!=null){
			if(iTalkAct.equals("iTalkTopic")){					//talk topic-发布话题
				Long userId = (Long) session.getAttribute("userId");
				Connection con = DataBaseUtil.getConnection();
				
				String clientToken = request.getParameter("clientToken");
				String sessionToken = (String) session.getAttribute("token");
				
				if(sessionToken!=null&&!clientToken.equals(sessionToken)){		//重复提交
					;
				}else{
					String topicContent = request.getParameter("talkTopic");
			    	String username = (String) session.getAttribute("username");
			    	TopicService topicService = new TopicServiceImpl();
					TopicBean topic = new TopicBean();
					topic.setUserId(userId);
					topic.setTopicContent(topicContent);
					topic.setUsername(username);
					topicService.insertObject(topic);
			    }
				//生成新令牌
				String token = generateToken(request);
				request.setAttribute("clientToken", token);
				//替换旧令牌
				session.setAttribute("token", token);
			    
				String next_sql = "select * from topic t where t.userid = ?";
				try {
					PreparedStatement pst = con.prepareStatement(next_sql);
					pst.setLong(1, userId);
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
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DataBaseUtil.closeConnection(con);
				}
			}else if(iTalkAct.equals("iTalkLogin")){				// login-登录
				String iTalkName = request.getParameter("iTalkName");
				String iTalkpwd = request.getParameter("iTalkpwd");
				Connection con = DataBaseUtil.getConnection();
				String sql = "select * from user t where t.username=? and t.password=?";
				PreparedStatement pst;
				try {
					pst = con.prepareStatement(sql);
					pst.setString(1, iTalkName);
					pst.setString(2, iTalkpwd);
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
						long userId = ubean.getUserId();
						session.setAttribute("userId", userId);
						
						String next_sql = "select * from topic t where t.userid = ?";
						try {
							pst = con.prepareStatement(next_sql);
							pst.setLong(1, userId);
							rs = pst.executeQuery();			//preparedStatement用executeQuery而不是executeQuery(sql)!
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
		
	}
	
	/**
	 * struts 令牌机制
	 * @param request
	 * @return  生成令牌
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
	 * @return 16进制的字符串表示
	 */
	protected String toHex(byte buffer[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buffer.length; i++)
            sb.append(Integer.toHexString((int) buffer[i] & 0xff));
        return (sb.toString());
    }
	
}
