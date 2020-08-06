package com.fuzzyAQP.dao;

import java.util.List;









import com.fuzzyAQP.pojo.PaperSetEncryptPojo;
import com.fuzzyAQP.pojo.SubjectDetailsPojo;
import com.fuzzyAQP.pojo.TeacherDetailsPojo;

public interface TeacherDetailsDao {

	
	public boolean addTeacherDetails(TeacherDetailsPojo teacherDetailsPojo);
	
    boolean  teacherLogin(String username, String password);
	
	public List<TeacherDetailsPojo> getTeacherList();

	boolean deleteTeacher(long teacher_id);

	List<TeacherDetailsPojo> getTeacheListOnID(long teacher_id);

	boolean updateDetails(TeacherDetailsPojo teacherDetailsPojo);

	public TeacherDetailsPojo getDetailsOnEmail(String email);

	public List<TeacherDetailsPojo> teacherDetails(String teacher_name);
	
	public boolean addPaperSetDetails(PaperSetEncryptPojo pe);

	public List<SubjectDetailsPojo> getSubjectList(long teacher_id);
	
	public List<PaperSetEncryptPojo> getPdfList(String subject);
	
	public List<TeacherDetailsPojo> getSubadminTeacherList(String username);

	List<TeacherDetailsPojo> getTeacherListSubAdmin(String email);
}
