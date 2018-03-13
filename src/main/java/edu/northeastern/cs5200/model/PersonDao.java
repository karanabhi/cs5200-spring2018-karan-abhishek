/**
 * 
 */
package edu.northeastern.cs5200.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.Developer;
import edu.northeastern.cs5200.objects.Person;
import edu.northeastern.cs5200.objects.Phone;

/**
 * @author Abhishek Karan
 *
 */
public class PersonDao {

	private Connection conn=null;	
	private PreparedStatement pstmt=null;
	private int result=0;
	private ResultSet results=null;	
	private static PersonDao instance=null;
	private String connString="jdbc:mysql://cs5200-spring2018-karan.caa00vj8vym7.us-east-1.rds.amazonaws.com/cs5200_spring2018_karan";
	private String uName="karan";
	private String pass="yourPa$$word123";
		
	public static PersonDao getInstance() {
		if(instance==null) {
			return new PersonDao();
		}
		return instance;
	}
	
	private PersonDao() {
	}

	@SuppressWarnings("static-access")
	public int createPerson(Person person)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO person (firstName,lastName,username,password,email,dob) values(?,?,?,?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setString(1, person.getFirstName());	
			pstmt.setString(2, person.getLastName());		
			pstmt.setString(3, person.getUsername());
			pstmt.setString(4, person.getPassword());
			pstmt.setString(5, person.getEmail());
			pstmt.setString(6, person.getDob());
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createPerson() Person Status:"+result);	
	
			
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
	public int createPhoneNumber(int personId,Phone phone)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO phone (person_id,phone,`primary`) values(?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, personId);	
			pstmt.setString(2, phone.getPhone());		
			pstmt.setInt(3, phone.getPrimary());
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createPhoneNumber() Phone Status:"+result);	
	
			
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

	public int updatePersonPhoneNumber(int personId,Phone phone)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="UPDATE phone SET phone=? WHERE person_id=? AND `primary`=?";
			pstmt=conn.prepareStatement(str);	
			pstmt.setString(1, phone.getPhone());
			pstmt.setInt(2, personId);
			pstmt.setInt(3, 1);
			
			result=pstmt.executeUpdate();
			System.out.println("updatePersonPhoneNumber() Phone Status:"+result);
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
	
	public int deletePersonPrimaryAddress(int personId)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			
			String str="DELETE FROM address WHERE person_id=? AND `primary=?";
			pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, personId);
			pstmt.setInt(2, 1);
			
			result= pstmt.executeUpdate();
			System.out.println("deletePersonPrimaryAddress() Address Status:"+result);	
			
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
	public int createAddress(int personId,Address address)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(connString,uName,pass);
			String str="INSERT INTO address (person_id,street1,street2,city,state,zip,`primary`) values(?,?,?,?,?,?,?) ";
			pstmt=conn.prepareStatement(str,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, personId);	
			pstmt.setString(2, address.getStreet1());		
			pstmt.setString(3, address.getStreet2());
			pstmt.setString(4, address.getCity());
			pstmt.setString(5, address.getState());
			pstmt.setString(6, address.getZip());
			pstmt.setInt(7, address.getPrimary());
			
			result=pstmt.executeUpdate();
			results = pstmt.getGeneratedKeys();

			if (results.next()) {
			    result= results.getInt(1);
			}
			System.out.println("createAddress() Address Status:"+result);	
	
			
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
