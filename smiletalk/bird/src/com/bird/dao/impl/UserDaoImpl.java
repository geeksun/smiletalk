package com.bird.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bird.dao.UserDao;
import com.bird.db.DBConnection;
import com.bird.db.DataBaseUtil;
import com.bird.domain.UserBean;
import com.bird.util.DateUtil;

public class UserDaoImpl implements UserDao {
	private Connection con;

	public int deleteObject(Object o) {
		
		return 0;
	}

	/**
	 *  判断用户名是否唯一
	 */
	public Object getObject(Object o) {
		if(o==null){
			return null;
		}
		UserBean user = (UserBean) o;
		String userName = user.getUserName();
		String next_sql = "select * from user u where u.userName = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(next_sql);
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			UserBean ubean = null;
			if(rs.next()){
				ubean = new UserBean();
				ubean.setUserName(rs.getString("userName"));
			}
			DBConnection.closeConnection(con);
			return ubean;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  判断邮件是否唯一
	 */
	public Object getUserByEamil(Object o) {
		if(o==null){
			return null;
		}
		UserBean user = (UserBean) o;
		String email = user.getEmail();
		String next_sql = "select * from user u where u.email = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(next_sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			UserBean ubean = null;
			if(rs.next()){
				ubean = new UserBean();
				ubean.setUserName(rs.getString("userName"));
			}
			DBConnection.closeConnection(con);
			return ubean;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<UserBean> getObjectList(Object o) {
		
		return null;
	}

	public int insertObject(Object o) {
		if(o==null){
			return 0;
		}
		UserBean user = (UserBean) o;
		Connection con = DataBaseUtil.getConnection();
		String exe_sql = "insert user (userName,password,email,regTime,isActive) values (?,?,?,?,'0')";
		try {
			PreparedStatement pst = con.prepareStatement(exe_sql);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			Date d = new Date();
			String regTime = DateUtil.getDateString(d);
			pst.setString(4, regTime);
			int result = pst.executeUpdate();
			DBConnection.closeConnection(con);
			return result;
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 *  用户登录
	 */
	public UserBean loginUser(UserBean user) {
		if(user==null){
			return null;
		}
		String userName = user.getUserName();
		String pwd = user.getPassword();
		String next_sql = "select * from user u where u.userName = ? and u.password = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(next_sql);
			pst.setString(1, userName);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			UserBean ubean = null;
			List<UserBean> userList = new ArrayList<UserBean>();
			while(rs.next()){
				ubean = new UserBean();
				ubean.setUserId(rs.getLong("userId"));
				ubean.setUserName(rs.getString("userName"));
				userList.add(ubean);
			}
			DBConnection.closeConnection(con);
			return userList.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  更新用户状态：写入验证码
	 */
	public void updateObject(UserBean userBean) {
		if(userBean==null){
			return;
		}
		String validateCode = userBean.getValidateCode();
		String sql = "update user u set u.validateCode = ? where u.userName = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, validateCode);
			pst.setString(2, userBean.getUserName());
			pst.executeUpdate();
			DBConnection.closeConnection(con);
		}catch(Exception e){
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	

}
