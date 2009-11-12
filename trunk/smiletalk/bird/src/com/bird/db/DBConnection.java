package com.bird.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @author jzq
 *  数据库联接类：单例方法
 *  2009-11-10
 */
public class DBConnection {
	private static DataSource ds;
	private static final DBConnection DBCON = new DBConnection();
	
	private DBConnection() {
		try	{
			Context initCtx = new InitialContext(); 
			Context ctx = (Context) initCtx.lookup("java:comp/env");		
			ds = (DataSource) ctx.lookup("jdbc/italk"); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnection getDBConnection() {
		return DBCON;
	}
	
	/**
	 * @return 连接池数据源
	 */
	public DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * @return 数据库链接
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		if(ds==null){
			try{
				Context initCtx = new InitialContext(); 
				Context ctx = (Context) initCtx.lookup("java:comp/env");		
				ds = (DataSource) ctx.lookup("jdbc/italk"); 
				con = ds.getConnection();
				return con;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		con = ds.getConnection();
		return con;
	}
	
	/**
	 * @param con
	 * 关闭数据库链接
	 */
	public static void closeConnection(Connection con) {
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		
	}

}
