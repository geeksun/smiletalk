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

	public Object getObject(Object o) {
		if(o==null){
			return null;
		}
		UserBean user = (UserBean) o;
		String userName = user.getUserName();
		String email = user.getEmail();
		String next_sql = "select * from user u where u.userName = ? or u.email = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(next_sql);
			pst.setString(1, userName);
			pst.setString(2, email);
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
		String exe_sql = "insert user (userName,password,email,regTime) values (?,?,?,?)";
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

	public UserBean loginUser(UserBean userBean) {
		if(userBean==null){
			return null;
		}
		UserBean user = (UserBean) userBean;
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
	

}
