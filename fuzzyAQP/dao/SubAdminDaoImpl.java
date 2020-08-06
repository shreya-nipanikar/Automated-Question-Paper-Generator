package com.fuzzyAQP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;











import com.fuzzyAQP.pojo.CounsilDetailsPojo;
import com.fuzzyAQP.pojo.QuestionDetailsPojo;
import com.fuzzyAQP.pojo.SubAdminDetailsPojo;
import com.fuzzyAQP.utility.DBConnection;

public class SubAdminDaoImpl implements SubAdminDao {

	@Override
	public boolean AddSubAdmin(SubAdminDetailsPojo subAdminDetailsPojo) {
		// TODO Auto-generated method stub
		
		
      Connection conn=null;
      PreparedStatement ps=null;
		try {
			
			List<CounsilDetailsPojo> list=new ArrayList<CounsilDetailsPojo>();
			conn=DBConnection.getConnection();
			 ps=conn.prepareStatement("select * from sub_admin_details where email=?");
			ps.setString(1, subAdminDetailsPojo.getEmail());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return false;
			}
			else{
				conn=DBConnection.getConnection();
				ps=conn.prepareStatement("insert into sub_admin_details(name,contact_no,email,password,roll_id) values(?,?,?,?,?)");
				 
				ps.setString(1,subAdminDetailsPojo.getName());
				ps.setString(2, subAdminDetailsPojo.getContact_no());
				ps.setString(3, subAdminDetailsPojo.getEmail());
				ps.setString(4, subAdminDetailsPojo.getPassword());
				ps.setInt(5, subAdminDetailsPojo.getRoll_id());
				
				int i=ps.executeUpdate();
				
				if(i>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public List<SubAdminDetailsPojo> getAllSubAdmin() {
		// TODO Auto-generated method stub
		
Connection conn=null;
		
		try {
			
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from sub_admin_details");
			
			//ps.setDouble(1, studentid);
			
			ResultSet rs=ps.executeQuery();
			List<SubAdminDetailsPojo> subAdminList=new ArrayList<SubAdminDetailsPojo>();

			while(rs.next())
			{
				SubAdminDetailsPojo subAdminDetailsPojo=new SubAdminDetailsPojo();
				subAdminDetailsPojo.setId(rs.getLong("id"));
				subAdminDetailsPojo.setName(rs.getString("name"));
				subAdminDetailsPojo.setContact_no(rs.getString("contact_no"));
				subAdminDetailsPojo.setEmail(rs.getString("email"));
				subAdminDetailsPojo.setPassword(rs.getString("password"));
				
			
				
				subAdminList.add(subAdminDetailsPojo);
			}
			return subAdminList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteSubAdmin(int Id) {
		// TODO Auto-generated method stub
		
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement("delete from sub_admin_details where id=?");
			
			ps.setInt(1, Id);
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public SubAdminDetailsPojo getSubAdmin(long id) {
		// TODO Auto-generated method stub
		
Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from sub_admin_details where id=? ");
			
			ps.setLong(1, id);			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				SubAdminDetailsPojo subAdminDetailsPojo=new SubAdminDetailsPojo();
				subAdminDetailsPojo.setId(rs.getLong("id"));
				subAdminDetailsPojo.setName(rs.getString("name"));
				subAdminDetailsPojo.setContact_no(rs.getString("contact_no"));
				subAdminDetailsPojo.setEmail(rs.getString("email"));
				subAdminDetailsPojo.setPassword(rs.getString("password"));
			
				
				return subAdminDetailsPojo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatesubAdminn(SubAdminDetailsPojo subAdminDetailsPojo) {
		// TODO Auto-generated method stub
		
Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("update sub_admin_details set name=?,contact_no=?,email=? where id=?");
			
			ps.setString(1, subAdminDetailsPojo.getName());
			ps.setString(2, subAdminDetailsPojo.getContact_no());
			ps.setString(3, subAdminDetailsPojo.getEmail());
			//ps.setString(4, subAdminDetailsPojo.getPassword());
			ps.setLong(4, subAdminDetailsPojo.getId());
			
			
			
			int i=ps.executeUpdate();
			System.out.println("ps"+ps);
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean Login(String username, String password) {
		// TODO Auto-generated method stub
		
Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from sub_admin_details where email=? and password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public String getNameOnEmail(String email) {
		// TODO Auto-generated method stub
        Connection conn=null;
		String username=null;
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from sub_admin_details where email=? ");
			
			ps.setString(1, email);			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				username=rs.getString("name");
				
				System.out.println("username in impl"+username);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return username;
	}

	@Override
	public List<SubAdminDetailsPojo> getAllSubAdmin(String subadmin_name) {
		// TODO Auto-generated method stub
Connection conn=null;
		
		try {
			
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from sub_admin_details where name like '%' ? '%'");
			
			ps.setString(1,subadmin_name );
			
			ResultSet rs=ps.executeQuery();
			System.out.println("pss"+ps);
			List<SubAdminDetailsPojo> subAdminList=new ArrayList<SubAdminDetailsPojo>();

			while(rs.next())
			{
				SubAdminDetailsPojo subAdminDetailsPojo=new SubAdminDetailsPojo();
				subAdminDetailsPojo.setId(rs.getLong("id"));
				subAdminDetailsPojo.setName(rs.getString("name"));
				subAdminDetailsPojo.setContact_no(rs.getString("contact_no"));
				subAdminDetailsPojo.setEmail(rs.getString("email"));
				subAdminDetailsPojo.setPassword(rs.getString("password"));
				
			
				
				subAdminList.add(subAdminDetailsPojo);
			}
			return subAdminList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
