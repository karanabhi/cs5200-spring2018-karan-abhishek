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
 * Role Id: 1 is Owner
 * Role Id: 2 is Admin
 * Role Id: 1 is Writer
 * Role Id: 2 is Editor
 * Role Id: 2 is Reviewer
 */
public class RoleDao {

	private Connection conn=null;	
	private PreparedStatement pstmt=null;
	private int result=0;
	private ResultSet results=null;	
	private static RoleDao instance=null;
	private String connString="jdbc:mysql://cs5200-spring2018-karan.caa00vj8vym7.us-east-1.rds.amazonaws.com/cs5200_spring2018_karan";
	private String uName="karan";
	private String pass="yourPa$$word123"; 
	
	public static RoleDao getInstance() {	
		if(instance==null) {
			return new RoleDao();
		}
		return instance;
	}
	
	private RoleDao() {
	}

	@SuppressWarnings("static-access")
	public int assignWebsiteRole(int developerId, int websiteId, int roleId)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO role (role_id,developer_id,website_id) values(?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, roleId);
			pstmt.setInt(2, developerId);	
			pstmt.setInt(3, websiteId);
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("assignWebsiteRole() Role Status:"+result);	
			
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
	public int assignPageRole(int developerId, int pageId, int roleId)
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO role (role_id,developer_id,page_id) values(?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, roleId);
			pstmt.setInt(2, developerId);	
			pstmt.setInt(3, pageId);
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("assignWebsiteRole() Role Status:"+result);	
			
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

	public int deleteWebsiteRole(int developerId, int websiteId, int roleId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM role WHERE role_id=? AND developer_id=? AND website_id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, roleId);
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

	public int deletePageRole(int developerId, int pageId, int roleId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM role WHERE role_id=? AND developer_id=? AND page_id=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, roleId);
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
