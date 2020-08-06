package com.fuzzyAQP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fuzzyAQP.pojo.PaperSetEncryptPojo;
import com.fuzzyAQP.pojo.SubjectDetailsPojo;
import com.fuzzyAQP.pojo.TeacherDetailsPojo;
import com.fuzzyAQP.utility.DBConnection;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class TeacherDetailsDaoImpl implements TeacherDetailsDao {

	@Override
	public boolean addTeacherDetails(TeacherDetailsPojo teacherDetailsPojo) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
				try {
					
					List<TeacherDetailsPojo> list=new ArrayList<TeacherDetailsPojo>();
					conn=DBConnection.getConnection();
					 ps=conn.prepareStatement("select * from teacher_details where email=?");
					ps.setString(1, teacherDetailsPojo.getEmail_id());
					ResultSet rs=ps.executeQuery();
					
					/*while(rs.next())
					{
						TeacherDetailsPojo teacherDetailsPojo1=new TeacherDetailsPojo();
						teacherDetailsPojo1.setEmail_id(rs.getString("email"));
						teacherDetailsPojo1.setName(rs.getString("name"));
						 
						list.add(teacherDetailsPojo1);
						
					}*/
					if(rs.next()){
						return false;
					}
					else{
					//conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("insert into teacher_details(name,contact_no,email,password,branch,roll_id,add_by) values(?,?,?,?,?,?,?)");
					
					ps.setString(1, teacherDetailsPojo.getName());
					ps.setString(2, teacherDetailsPojo.getContact_no());
					ps.setString(3, teacherDetailsPojo.getEmail_id());
					ps.setString(4, teacherDetailsPojo.getPassword());
					ps.setString(5, teacherDetailsPojo.getBranch());
					ps.setInt(6, teacherDetailsPojo.getRoll_id());
					ps.setString(7, teacherDetailsPojo.getUsername());
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
	public List<TeacherDetailsPojo> getTeacherList() {
		// TODO Auto-generated method stub
		

	       Connection conn=null;
			
			try {
				List<TeacherDetailsPojo> list=new ArrayList<TeacherDetailsPojo>();
				conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement("select * from teacher_details");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
					teacherDetailsPojo.setBranch(rs.getString("branch"));
					teacherDetailsPojo.setContact_no(rs.getString("contact_no"));
					teacherDetailsPojo.setEmail_id(rs.getString("email"));
					teacherDetailsPojo.setId(rs.getLong("id"));
					teacherDetailsPojo.setName(rs.getString("name"));
					teacherDetailsPojo.setPassword(rs.getString("password"));
					
					list.add(teacherDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public List<TeacherDetailsPojo> getTeacherListSubAdmin(String email) {
		// TODO Auto-generated method stub
		

	       Connection conn=null;
			
			try {
				List<TeacherDetailsPojo> list=new ArrayList<TeacherDetailsPojo>();
				conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement("select * from teacher_details where add_by=?");
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
					teacherDetailsPojo.setBranch(rs.getString("branch"));
					teacherDetailsPojo.setContact_no(rs.getString("contact_no"));
					teacherDetailsPojo.setEmail_id(rs.getString("email"));
					teacherDetailsPojo.setId(rs.getLong("id"));
					teacherDetailsPojo.setName(rs.getString("name"));
					teacherDetailsPojo.setPassword(rs.getString("password"));
					
					list.add(teacherDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public boolean deleteTeacher(long teacher_id) {
		// TODO Auto-generated method stub
        Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from teacher_details where id=? ");
			
			ps.setLong(1, teacher_id);
			
			
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
	public List<TeacherDetailsPojo> getTeacheListOnID(long teacher_id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		try {
			List<TeacherDetailsPojo> list=new ArrayList<TeacherDetailsPojo>();
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from teacher_details where id=?");
			ps.setLong(1, teacher_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
				teacherDetailsPojo.setBranch(rs.getString("branch"));
				teacherDetailsPojo.setContact_no(rs.getString("contact_no"));
				teacherDetailsPojo.setEmail_id(rs.getString("email"));
				teacherDetailsPojo.setId(rs.getLong("id"));
				teacherDetailsPojo.setName(rs.getString("name"));
				teacherDetailsPojo.setPassword(rs.getString("password"));
				
				list.add(teacherDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateDetails(TeacherDetailsPojo teacherDetailsPojo) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;	
			try {
				
				conn=DBConnection.getConnection();
		    ps=conn.prepareStatement("update teacher_details set name=?,contact_no=?,email=?,branch=?  where id=?");
			
		    ps.setString(1, teacherDetailsPojo.getName());
			ps.setString(2, teacherDetailsPojo.getContact_no());
			ps.setString(3, teacherDetailsPojo.getEmail_id());
			//ps.setString(4, teacherDetailsPojo.getPassword());
			ps.setString(4, teacherDetailsPojo.getBranch());
			
			ps.setLong(5, teacherDetailsPojo.getId());
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
	public TeacherDetailsPojo getDetailsOnEmail(String email) {
		// TODO Auto-generated method stub
        Connection conn=null;
		String username=null;
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from teacher_details where email=? ");
			
			ps.setString(1, email);			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
				teacherDetailsPojo.setName(rs.getString("name"));
				teacherDetailsPojo.setId(rs.getLong("id"));
				
				//System.out.println("username in impl"+username);
				return teacherDetailsPojo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TeacherDetailsPojo> teacherDetails(String teacher_name) {
		// TODO Auto-generated method stub
		  Connection conn=null;
			
			try {
				List<TeacherDetailsPojo> list=new ArrayList<TeacherDetailsPojo>();
				conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement("select * from teacher_details where name like '%' ? '%'  OR branch=? ");
				ps.setString(1, teacher_name);
				ps.setString(2, teacher_name);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
					teacherDetailsPojo.setBranch(rs.getString("branch"));
					teacherDetailsPojo.setContact_no(rs.getString("contact_no"));
					teacherDetailsPojo.setEmail_id(rs.getString("email"));
					teacherDetailsPojo.setId(rs.getLong("id"));
					teacherDetailsPojo.setName(rs.getString("name"));
					teacherDetailsPojo.setPassword(rs.getString("password"));
					
					list.add(teacherDetailsPojo);
				}
				if(list.size()<=0){
					PreparedStatement ps1=conn.prepareStatement("select * from teacher_subject_details where subject=?");
					ps1.setString(1, teacher_name);
				
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next()){
						
						long t_id=rs1.getLong("teacher_id");
				
						PreparedStatement ps2=conn.prepareStatement("select * from teacher_details where id=?");
						ps2.setLong(1, t_id);
						
						ResultSet rs2=ps2.executeQuery();
						while(rs2.next()){
							TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
							teacherDetailsPojo.setBranch(rs2.getString("branch"));
							teacherDetailsPojo.setContact_no(rs2.getString("contact_no"));
							teacherDetailsPojo.setEmail_id(rs2.getString("email"));
							teacherDetailsPojo.setId(rs2.getLong("id"));
							teacherDetailsPojo.setName(rs2.getString("name"));
							teacherDetailsPojo.setPassword(rs2.getString("password"));
						list.add(teacherDetailsPojo);
						}
					}
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	
	public boolean addPaperSetDetails(PaperSetEncryptPojo pe) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
				try {
					
					
					conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("insert into paper_set_details(teacher_id,time,set_name,subject,date) values(?,?,?,?,?)");
					
					ps.setLong(1, pe.getTeacher_id());
					ps.setDouble(2, pe.getTime());
					ps.setString(3, pe.getSet_name());
					ps.setString(4,pe.getSubject());
					ps.setString(5, pe.getDate());
					
					
					int x=ps.executeUpdate();
					
					if(x>0)
					{
						return true;
					}
					else
					{
						return false;
					}
					/*}*/
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		
		
		
		return false;
	}
	@Override
	 public List<SubjectDetailsPojo> getSubjectList(long teacher_id) {
	  // TODO Auto-generated method stub
	  
	  
	   Connection conn=null;
	   
	   try {
	    List<SubjectDetailsPojo> list=new ArrayList<SubjectDetailsPojo>();
	    conn=DBConnection.getConnection();
	    PreparedStatement ps=conn.prepareStatement("select subject from teacher_subject_details where teacher_id=?");
	    ps.setLong(1, teacher_id);
	    ResultSet rs=ps.executeQuery();
	    while(rs.next()){
	     SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
	     subjectDetailsPojo.setSubject(rs.getString("subject"));
	     list.add(subjectDetailsPojo);
	    }
	    return list;
	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  return null;
	 }
	
	@Override
	 public List<PaperSetEncryptPojo> getPdfList(String subject) {
	  // TODO Auto-generated method stub
	  
	   Connection conn=null;
	   
	   try {
	    List<PaperSetEncryptPojo> list=new ArrayList<PaperSetEncryptPojo>();
	    conn=DBConnection.getConnection();
	    PreparedStatement ps=conn.prepareStatement("select * from paper_set_details where subject=?");
	    ps.setString(1, subject);
	    ResultSet rs=ps.executeQuery();
	    while(rs.next()){
	     PaperSetEncryptPojo paperSetEncryptPojo=new PaperSetEncryptPojo();
	     paperSetEncryptPojo.setSubject(rs.getString("subject"));
	     paperSetEncryptPojo.setDate(rs.getString("date"));
	     paperSetEncryptPojo.setSet_name(rs.getString("set_name"));
	     paperSetEncryptPojo.setTeacher_id(rs.getLong("teacher_id"));
	     paperSetEncryptPojo.setTime(rs.getDouble("time"));
	     list.add(paperSetEncryptPojo);
	    }
	    return list;
	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  
	  return null;
	 }
	
	@Override
	 public List<TeacherDetailsPojo> getSubadminTeacherList(String username) {
	  // TODO Auto-generated method stub
	   Connection conn=null;
	   
	   try {
	    List<TeacherDetailsPojo> list=new ArrayList<TeacherDetailsPojo>();
	    conn=DBConnection.getConnection();
	    PreparedStatement ps=conn.prepareStatement("select * from teacher_details where add_by=?");
	    ps.setString(1, username);
	    ResultSet rs=ps.executeQuery();
	    System.out.println("ppppppppppp"+ps);
	    while(rs.next()){
	     TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
	     teacherDetailsPojo.setBranch(rs.getString("branch"));
	     teacherDetailsPojo.setContact_no(rs.getString("contact_no"));
	     teacherDetailsPojo.setEmail_id(rs.getString("email"));
	     teacherDetailsPojo.setId(rs.getLong("id"));
	     teacherDetailsPojo.setName(rs.getString("name"));
	     teacherDetailsPojo.setPassword(rs.getString("password"));
	     teacherDetailsPojo.setAdd_by(rs.getString("add_by"));
	     list.add(teacherDetailsPojo);
	    }
	    return list;
	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  return null;
	 }

}
