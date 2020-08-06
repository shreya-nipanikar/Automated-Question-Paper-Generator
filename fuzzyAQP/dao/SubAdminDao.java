package com.fuzzyAQP.dao;

import java.util.List;











import com.fuzzyAQP.pojo.QuestionDetailsPojo;
import com.fuzzyAQP.pojo.SubAdminDetailsPojo;



public interface SubAdminDao {

	public boolean AddSubAdmin(SubAdminDetailsPojo subAdminDetailsPojo);
	public boolean Login(String username,String password);
	
	public List<SubAdminDetailsPojo> getAllSubAdmin();
	
	public boolean deleteSubAdmin(int Id);
	public SubAdminDetailsPojo getSubAdmin(long id);
	public boolean updatesubAdminn(SubAdminDetailsPojo subAdminDetailsPojo);
	
	public String getNameOnEmail(String email);
	public List<SubAdminDetailsPojo> getAllSubAdmin(String subadmin_name);


	

}
