package com.bird.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {

	/**
	 * @return 数据库链接
	 */
	public synchronized static Connection getConnection(){   
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/italk?useUnicode=true&amp;characterEncoding=gbk","root","geeksun");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * @param con
	 * 关闭数据库链接
	 */
	public static void closeConnection(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
