/**
 * 
 */
package edu.northeastern.cs5200.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.northeastern.cs5200.objects.Widget;

/**
 * @author Abhishek Karan
 *
 * Priviledge Id: 1 is Create
 * Priviledge Id: 2 is Update
 * Priviledge Id: 1 is Read
 * Priviledge Id: 2 is Delete
 */
public class PriviledgeDao {

	private Connection conn=null;	
	private PreparedStatement pstmt=null;
	private int result=0;
	private ResultSet results=null;	
	private static PriviledgeDao instance=null;
	private String connString="jdbc:mysql://cs5200-spring2018-karan.caa00vj8vym7.us-east-1.rds.amazonaws.com/cs5200_spring2018_karan";
	private String uName="karan";
	private String pass="yourPa$$word123"; 
	
	public static PriviledgeDao getInstance() {	
		if(instance==null) {
			return new PriviledgeDao();
		}
		return instance;
	}
	
	private PriviledgeDao() {
	}

	@SuppressWarnings("static-access")
	public int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO priviledge (priviledge_id,developer_id,website_id) values(?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, priviledgeId);
			pstmt.setInt(2, developerId);	
			pstmt.setInt(3, websiteId);
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("assignWebsitePriviledge() Priviledge Status:"+result);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}

	@SuppressWarnings("static-access")
	public int assignPagePriviledge(int developerId, int pageId, int priviledgeId)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO priviledge (priviledge_id,developer_id,page_id) values(?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, priviledgeId);
			pstmt.setInt(2, developerId);	
			pstmt.setInt(3, pageId);
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("assignWebsitePriviledge() Priviledge Status:"+result);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}

	public int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM priviledge WHERE priviledge_id=? AND developer_id=? AND website_id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, priviledgeId);
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, websiteId);
			
			result= pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}	

	public int deletePagePriviledge(int developerId, int pageId, int priviledgeId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM priviledge WHERE priviledge_id=? AND developer_id=? AND page_id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, priviledgeId);
			pstmt.setInt(2, developerId);
			pstmt.setInt(3, pageId);
			
			result= pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();	
			}
		}
		
		return result;
	}	

	
}
