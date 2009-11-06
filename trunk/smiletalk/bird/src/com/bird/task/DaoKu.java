package com.bird.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bird.util.DateUtil;

public abstract class DaoKu {
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection con1 = null;		
		Connection con2 = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		PreparedStatement stmt4 = null;
		PreparedStatement stmt5 = null;
		//PreparedStatement stmt6 = null;
		
		ResultSet rs = null;
		ResultSet rs2 = null;
		int counts[] ;
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			/*con1 = java.sql.DriverManager.getConnection("jdbc:oracle:oci8:@sdjsm","scott","tiger");*/
		    //mysql -uroot -proot -h 203.134.242.60 -P 23306 -Dsms  sms_accept
			//"jdbc:mysql://localhost/italk?useUnicode=true&amp;characterEncoding=gbk","root","geeksun"
			con1 = java.sql.DriverManager.getConnection("jdbc:mysql://203.134.242.60:23306/sms","root","root");
			
			con2 = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/italk","root","geeksun");			
			
			stmt1 = con1.prepareStatement("select * from sms_accept s where s.bookstatus=? and lower(s.msg) like 'mic%'");			
			
			stmt2 = con2.prepareStatement("insert topic (topicContent,username,userid,topicTime,topicStatus,remark) values (?,?,?,?,?,'sms')");		
			
			stmt3 = con1.prepareStatement("update sms_accept s set s.bookstatus=? where s.bookstatus=? and lower(s.msg) like 'mic%'");
			
			stmt4 = con2.prepareStatement("insert user (username,password,regTime,remark) values (?,?,?,'sms')");
			
			stmt5 = con2.prepareStatement("select userId from user u where u.username=?");
			
			/*stmt6 = con2.prepareStatement("select topicId from topic t where t.username=?");*/
			
			con1.setAutoCommit(false);
			con2.setAutoCommit(false);		//rollback�����Զ��ύΪfalse
			
			stmt1.setInt(1, 0);		//Ĭ��0���޸ĺ�1
		    rs = stmt1.executeQuery();

		    while(rs.next()){			//rs ���Ƿ��м�¼ֻ����next()�жϣ����������Ƿ�Ϊnull�� ����rs.next()������֮��rs.next()�Ͳ�������
		    	stmt3.setInt(1, 1);
		    	stmt3.setInt(2, 0);
		    	stmt3.addBatch();
		    	
		    	String topicContent = rs.getString("msg");
		    	String username = rs.getString("mobile");
		    	String topicTime = DateUtil.getDateString(rs.getDate("arrivetime"));
		    	
		    	if(username!=null){			//�û�������Ψһ
		    		stmt5.setString(1, username);
		    		rs2 = stmt5.executeQuery();
		    		if(!rs2.next()){			//����û�и��û���д��һ����¼
		    			stmt4.setString(1, username);
				    	stmt4.setString(2, username);
				    	stmt4.setString(3, topicTime);
				    	stmt4.execute();			//�û�����������д�룬��������ظ����û�������
				    	//stmt4.addBatch();
				    	
		    		}
		    	}
		    	
		    	/*if(username!=null){
		    		stmt6.setString(1, username);
		    		rs = stmt6.executeQuery();
		    		if(rs.next()){*/
		    			String userid = null ;
		    			rs2 = stmt5.executeQuery();
		    			if(rs2.next()){
		    				userid = rs2.getString("userid");
		    				stmt2.setString(1, topicContent);
					    	stmt2.setString(2, username);
					    	stmt2.setString(3, userid);
					    	stmt2.setString(4, topicTime);		
					    	stmt2.setString(5, "1");
					    	//����������sql
					    	stmt2.addBatch();	
		    			}
		    		//}
		    	//}
		    	
		    	
		    }
		    counts = stmt3.executeBatch();
		    con1.commit();
		    System.out.println("sms_accept��������"+counts.length+"������");
		    
		    counts = stmt2.executeBatch();		
		    con2.commit();
			System.out.println("topic��������"+counts.length+"������");
			
			/*counts = stmt4.executeBatch();
			System.out.println("user��������"+counts.length+"������");*/
		} catch (SQLException e) {
			try {
				con1.rollback();
				con2.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{					//�ر����ӡ��ͷ���Դ
			try {
				con1.close();
				con2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
}
