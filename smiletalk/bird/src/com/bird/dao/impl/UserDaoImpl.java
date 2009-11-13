package com.bird.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.bird.dao.UserDao;
import com.bird.db.DBConnection;
import com.bird.domain.UserBean;

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

	public List<UserBean> getObjectList(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertObject(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
