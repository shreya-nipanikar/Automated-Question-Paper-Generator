package com.fuzzyAQP.dao;

import java.util.List;
import java.util.Set;

import com.fuzzyAQP.pojo.CustomizePojo;
import com.fuzzyAQP.pojo.PaperSetDetailsPojo;
import com.fuzzyAQP.pojo.PaperSetEncryptPojo;
import com.fuzzyAQP.pojo.QuestionDetailsPojo;
import com.fuzzyAQP.pojo.SubjectDetailsPojo;


public interface SubjectDetailsDao {

	public boolean addSubjectDetails(SubjectDetailsPojo subjectDetailsPojo);

	public List<SubjectDetailsPojo> getAllDetailsSubject(long teacher_id);

	public SubjectDetailsPojo getSubjectDetailsOnID(long sub_id);

	public boolean updateDetails(SubjectDetailsPojo subjectDetailsPojo);

	public boolean deleteSubject(long subject_id);

	public SubjectDetailsPojo getSubjectOnSubName(String subject_name);

	//List<SubjectDetailsPojo> getSubjectListOnID(long subject_id);
	public List<SubjectDetailsPojo> getBranchList();

	public List<SubjectDetailsPojo> getYearList(String branch);

	public List<SubjectDetailsPojo> getSemList(String year);

	public List<SubjectDetailsPojo> getSubjectList(String branch, String sem, long teacher_id);

	//public boolean addSubjectDetails(QuestionDetailsPojo questionDetailsPojo);

	public boolean addTeacherQuestionDetails(QuestionDetailsPojo questionDetailsPojo);

	public boolean addTeacherQuestionDetailsInQuestion(
			QuestionDetailsPojo questionDetailsPojo);

	public long getLastQuestionID();

	public boolean addTeacherQuestionDetailsInMarksScheme(QuestionDetailsPojo questionDetailsPojo);
	
	
	public List<QuestionDetailsPojo> getAllQuestion();
	
	int getModuleBySubject(String subject);
	
	public List<QuestionDetailsPojo> getEasyQuestionByOsm(String subject,int osm);
	public List<QuestionDetailsPojo> getMediumQuestionByOsm(String subject,int osm);
	public List<QuestionDetailsPojo> getHardQuestionByOsm(String subject,int osm);
	
	
	public List<QuestionDetailsPojo> getEasyQuestionByTsm(String subject,int tsm);
	public List<QuestionDetailsPojo> getMediumQuestionByTsm(String subject,int tsm);
	public List<QuestionDetailsPojo> getHardQuestionByTsm(String subject,int tsm);
	
	public boolean addSet1Details(Set<QuestionDetailsPojo> tmp1QuestionList10, PaperSetDetailsPojo paper);
	
	public List<QuestionDetailsPojo> getQuestion(long q_id);

	public boolean saveCustoizeQuestion(List<CustomizePojo> queList, String set_status);
	
	
	 public List<QuestionDetailsPojo> getEasyQuestionBytemp2(String subject,int mark,int fmod,int tmod);
	 public List<QuestionDetailsPojo> getMediumQuestionBytemp2(String subject,int mark,int fmod,int tmod);
	 public List<QuestionDetailsPojo> getHardQuestionBytemp2(String subject,int mark,int fmod,int tmod) ;
	 
	 public List<CustomizePojo> getCustomizeDetailsFor30Marks(String subject,int fmod,int tmod);
	 
	 public List<CustomizePojo> getCustomizeDetailsFor80Marks(String subject);

	public List<CustomizePojo> getustomListSet1(String set_status);
	
	public boolean deleteAllFromCustomize();

	public boolean deleteQuestion(long question_id);

	QuestionDetailsPojo getQuestionDetails(Long question_id);

	public PaperSetEncryptPojo getFileDetails(String pdf);
}
