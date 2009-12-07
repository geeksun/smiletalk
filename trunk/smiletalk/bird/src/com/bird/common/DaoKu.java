package com.bird.common;

import java.sql.*;

public abstract class DaoKu {
	
	public static void main(String[] args) {
		
		Connection con1 = null;		
		Connection con2 = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
	
		int temp = 0;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			/*con1 = java.sql.DriverManager.getConnection("jdbc:oracle:oci8:@sdjsm","scott","tiger");*/
		    //mysql -uroot -proot -h 203.134.242.60 -P 23306 -Dsms  sms_accept
			con1 = java.sql.DriverManager.getConnection("jdbc:mysql://203.134.242.60:3306/sms","root","root");
			
			con2 = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/italk","root","geeksun");			
			
			stmt1 = con1.prepareStatement("select * from sms_accept s where s.bookstatus=0 and lower(s.msg) like 'mic%'");			
			
			stmt2 = con2.prepareStatement("insert italk (topicContent,userid,topicTime,bookstatus) values (?,?,?,?)");			
			   		
		    int i = 1;
		    ResultSet rs = stmt1.executeQuery();
		    while(rs.next()){
		    	stmt2.setString(1, rs.getString(3));
		    	stmt2.setLong(2, Long.valueOf(rs.getString(2)));
		    	//stmt2.setString(3, rs.getDate(4));			    	
		    	stmt2.addBatch();
		    }
		    int counts[] = stmt2.executeBatch();				
			System.out.print("共处理了"+counts.length+"条数据");

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				con1.close();
				con2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		//关闭连接、释放资源
		/*EMP表
		 * stmt2 = con2.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
		
		while(rs.next()){		    	
	    	stmt2.setInt(1, rs.getInt(1));
	    	stmt2.setString(2, rs.getString(2));
	    	stmt2.setString(3, rs.getString(3));
	    	stmt2.setInt(4, rs.getInt(4));
	    	stmt2.setString(5, rs.getString(5));
	    	stmt2.setInt(6, rs.getInt(6));
	    	stmt2.setInt(7, rs.getInt(7));
	    	stmt2.setInt(8, rs.getInt(8));
	    	
	    	stmt2.addBatch();	
	    }*/
		
	}
	
}
