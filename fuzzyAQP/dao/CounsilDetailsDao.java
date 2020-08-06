package com.fuzzyAQP.dao;

import java.util.List;




import com.fuzzyAQP.pojo.CounsilDetailsPojo;


public interface CounsilDetailsDao {

	
	public boolean addCouncileDetails(CounsilDetailsPojo councileDetailsPojo);
	
    boolean teacherLogin(String username, String password);
	
	public List<CounsilDetailsPojo> getCouncileList();

	boolean deleteCouncile(long councile_id);

	List<CounsilDetailsPojo> getCouncileListOnID(long councile_id);

	boolean updateDetails(CounsilDetailsPojo councileDetailsPojo);

	public List<CounsilDetailsPojo> getCouncileList(String counsil_name);
}
