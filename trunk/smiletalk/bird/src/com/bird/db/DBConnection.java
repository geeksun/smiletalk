package com.bird.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @author jzq
 *  数据库联接类
 *  2009-11-10
 */
public class DBConnection {
	
	private DataSource ds;
	private static final DBConnection DBCON = new DBConnection();
	
	private DBConnection() {
		super();
		try
		{
			Context initCtx = new InitialContext(); 
			//System.out.println("====InitialContext()=====");
			Context ctx = (Context) initCtx.lookup("java:comp/env");		
			//System.out.println("====initCtx.lookup(\"java:comp/env\")====");
			ds = (DataSource) ctx.lookup("jdbc/italk"); 
			//System.out.println("====ctx.lookup(\"jdbc/italk\");====");
		}
		catch(Exception e)
		{
			System.out.println("数据库连接错误：");
			e.printStackTrace();
		}
	}
	
	public static DBConnection getDBConnection()
	{
		/*if(DBCON == null){
			DBCON = new DBConnection();
		}*/
		return DBCON;
	}
	
	public DataSource getDataSource()
	{
		//System.out.println("ds:" + ds);
		return ds;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		
	}

}
