package com.fuzzyAQP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fuzzyAQP.pojo.CounsilDetailsPojo;

import com.fuzzyAQP.utility.DBConnection;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class CounsilDetailsDaoImpl implements CounsilDetailsDao {

	@Override
	public boolean addCouncileDetails(CounsilDetailsPojo councileDetailsPojo) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
				try {
					
					List<CounsilDetailsPojo> list=new ArrayList<CounsilDetailsPojo>();
					conn=DBConnection.getConnection();
					 ps=conn.prepareStatement("select * from counsil_details where email=?");
					ps.setString(1, councileDetailsPojo.getEmail_id());
					ResultSet rs=ps.executeQuery();
					
					/*while(rs.next())
					{
						CounsilDetailsPojo councileDetailsPojo2=new CounsilDetailsPojo();
						councileDetailsPojo2.setEmail_id(rs.getString("email"));
						councileDetailsPojo2.setName(rs.getString("name"));
						 
						list.add(councileDetailsPojo2);
					}*/
					if(rs.next()){
						return false;
					}
					else{
					//conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("insert into counsil_details(name,contact_no,email,password) values(?,?,?,?)");
					
					ps.setString(1, councileDetailsPojo.getName());
					ps.setString(2, councileDetailsPojo.getContact_no());
					ps.setString(3, councileDetailsPojo.getEmail_id());
					ps.setString(4, councileDetailsPojo.getPassword());
					//ps.setString(5, councileDetailsPojo.getBranch());
					
					int x=ps.executeUpdate();
					
					if(x>0)
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
	public boolean teacherLogin(String username, String password) {
		// TODO Auto-generated method stub
		
         Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from teacher_details where email=? and password=?");
			
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
	public List<CounsilDetailsPojo> getCouncileList() {
		// TODO Auto-generated method stub
		

	       Connection conn=null;
			
			try {
				List<CounsilDetailsPojo> list=new ArrayList<CounsilDetailsPojo>();
				conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement("select * from counsil_details");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					CounsilDetailsPojo councileDetailsPojo=new CounsilDetailsPojo();
					//councileDetailsPojo.setBranch(rs.getString("branch"));
					councileDetailsPojo.setContact_no(rs.getString("contact_no"));
					councileDetailsPojo.setEmail_id(rs.getString("email"));
					councileDetailsPojo.setId(rs.getLong("id"));
					councileDetailsPojo.setName(rs.getString("name"));
					councileDetailsPojo.setPassword(rs.getString("password"));
					
					list.add(councileDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public boolean deleteCouncile(long councile_id) {
		// TODO Auto-generated method stub
        Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from counsil_details where id=? ");
			
			ps.setLong(1, councile_id);
			
			
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
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CounsilDetailsPojo> getCouncileListOnID(long councile_id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		try {
			List<CounsilDetailsPojo> list=new ArrayList<CounsilDetailsPojo>();
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from counsil_details where id=?");
			ps.setLong(1,councile_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CounsilDetailsPojo councileDetailsPojo=new CounsilDetailsPojo();
				//councileDetailsPojo.setBranch(rs.getString("branch"));
				councileDetailsPojo.setContact_no(rs.getString("contact_no"));
				councileDetailsPojo.setEmail_id(rs.getString("email"));
				councileDetailsPojo.setId(rs.getLong("id"));
				councileDetailsPojo.setName(rs.getString("name"));
				councileDetailsPojo.setPassword(rs.getString("password"));
				
				list.add(councileDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateDetails(CounsilDetailsPojo councileDetailsPojo) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;	
			try {
				
				conn=DBConnection.getConnection();
		    ps=conn.prepareStatement("update counsil_details set name=?,contact_no=?,email=? where id=?");
			
		    ps.setString(1, councileDetailsPojo.getName());
			ps.setString(2, councileDetailsPojo.getContact_no());
			ps.setString(3, councileDetailsPojo.getEmail_id());
		//	ps.setString(4, councileDetailsPojo.getPassword());
		//	ps.setString(5, councileDetailsPojo.getBranch());
			
			ps.setLong(4, councileDetailsPojo.getId());
			int x=ps.executeUpdate();
			
			if(x>0)
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
	public List<CounsilDetailsPojo> getCouncileList(String counsil_name) {
		// TODO Auto-generated method stub
		
		 Connection conn=null;
			
			try {
				List<CounsilDetailsPojo> list=new ArrayList<CounsilDetailsPojo>();
				conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement("select * from counsil_details where name=?");
				ps.setString(1, counsil_name);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					CounsilDetailsPojo councileDetailsPojo=new CounsilDetailsPojo();
					//councileDetailsPojo.setBranch(rs.getString("branch"));
					councileDetailsPojo.setContact_no(rs.getString("contact_no"));
					councileDetailsPojo.setEmail_id(rs.getString("email"));
					councileDetailsPojo.setId(rs.getLong("id"));
					councileDetailsPojo.setName(rs.getString("name"));
					councileDetailsPojo.setPassword(rs.getString("password"));
					
					list.add(councileDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

}
