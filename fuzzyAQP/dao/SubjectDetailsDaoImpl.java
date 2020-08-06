package com.fuzzyAQP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fuzzyAQP.pojo.CustomizePojo;
import com.fuzzyAQP.pojo.PaperSetDetailsPojo;
import com.fuzzyAQP.pojo.PaperSetEncryptPojo;
import com.fuzzyAQP.pojo.QuestionDetailsPojo;
import com.fuzzyAQP.pojo.SubAdminDetailsPojo;
import com.fuzzyAQP.pojo.SubjectDetailsPojo;
import com.fuzzyAQP.utility.DBConnection;

public class SubjectDetailsDaoImpl implements SubjectDetailsDao {

	@Override
	public boolean addSubjectDetails(SubjectDetailsPojo subjectDetailsPojo) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
				try {
					
					List<SubjectDetailsPojo> list=new ArrayList<SubjectDetailsPojo>();
					conn=DBConnection.getConnection();
					 ps=conn.prepareStatement("select * from teacher_subject_details where subject=?");
					 ps.setString(1, subjectDetailsPojo.getSubject());
					// ps.setLong(2, subjectDetailsPojo.getTeacher_id());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()){
						return false;
					}
					else{
					//conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("insert into teacher_subject_details(branch,year,semester,no_of_module,subject,teacher_id) values(?,?,?,?,?,?)");
					
					ps.setString(1, subjectDetailsPojo.getBranch());
					ps.setString(2, subjectDetailsPojo.getYear());
					ps.setString(3, subjectDetailsPojo.getSemester());
					ps.setInt(4, subjectDetailsPojo.getNo_of_module());
					ps.setString(5, subjectDetailsPojo.getSubject());
					ps.setLong(6, subjectDetailsPojo.getTeacher_id());
					
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
	public List<SubjectDetailsPojo> getAllDetailsSubject(long teacher_id) {
		// TODO Auto-generated method stub
		
		   Connection conn=null;
			
					try {
						List<SubjectDetailsPojo> list=new ArrayList<SubjectDetailsPojo>();
						conn=DBConnection.getConnection();
						PreparedStatement ps=conn.prepareStatement("select * from teacher_subject_details where teacher_id=?");
						ps.setLong(1, teacher_id);
						ResultSet rs=ps.executeQuery();
						while(rs.next()){
							
							SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
							subjectDetailsPojo.setSubject(rs.getString("subject"));
							subjectDetailsPojo.setSub_id(rs.getLong("id"));
							list.add(subjectDetailsPojo);
						}
						return list;
					} catch (Exception e) {
						e.printStackTrace();
					}
		return null;
	}

	@Override
	public SubjectDetailsPojo getSubjectDetailsOnID(long sub_id) {
		// TODO Auto-generated method stub
		

Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from teacher_subject_details where id=? ");
			
			ps.setLong(1, sub_id);			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
				subjectDetailsPojo.setSubject(rs.getString("subject"));
				subjectDetailsPojo.setSub_id(rs.getLong("id"));
				subjectDetailsPojo.setBranch(rs.getString("branch"));
				subjectDetailsPojo.setNo_of_module(rs.getInt("no_of_module"));
				subjectDetailsPojo.setSemester(rs.getString("semester"));
				subjectDetailsPojo.setYear(rs.getString("year"));
				return subjectDetailsPojo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean deleteSubject(long subject_id) {
		// TODO Auto-generated method stub
        Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from teacher_subject_details where id=? ");
			
			ps.setLong(1, subject_id);
			
			
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

/*	@Override
	public List<SubjectDetailsPojo> getSubjectListOnID(long subject_id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		try {
			List<SubjectDetailsPojo> list=new ArrayList<SubjectDetailsPojo>();
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from teacher_subject_details where id=?");
			ps.setLong(1, subject_id);
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
*/
	@Override
	public boolean updateDetails(SubjectDetailsPojo subjectDetailsPojo) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;	
			try {
				
				conn=DBConnection.getConnection();
		    ps=conn.prepareStatement("update teacher_subject_details set branch=?,year=?,semester=?,no_of_module=?,subject=?  where id=?");
			
		    ps.setString(1, subjectDetailsPojo.getBranch());
			ps.setString(2, subjectDetailsPojo.getYear());
			ps.setString(3, subjectDetailsPojo.getSemester());
			ps.setInt(4, subjectDetailsPojo.getNo_of_module());
			ps.setString(5, subjectDetailsPojo.getSubject());
			
			ps.setLong(6, subjectDetailsPojo.getSub_id());
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
	public SubjectDetailsPojo getSubjectOnSubName(String subject_name) {
		// TODO Auto-generated method stub
		
Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from teacher_subject_details where subject=? ");
			
			ps.setString(1, subject_name);			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
				subjectDetailsPojo.setSubject(rs.getString("subject"));
				subjectDetailsPojo.setSub_id(rs.getLong("id"));
				subjectDetailsPojo.setBranch(rs.getString("branch"));
				subjectDetailsPojo.setNo_of_module(rs.getInt("no_of_module"));
				subjectDetailsPojo.setSemester(rs.getString("semester"));
				subjectDetailsPojo.setYear(rs.getString("year"));
				return subjectDetailsPojo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<SubjectDetailsPojo> getBranchList() {
		// TODO Auto-generated method stub

	       Connection conn=null;
			
			try {
				List<SubjectDetailsPojo> list=new ArrayList<SubjectDetailsPojo>();
				conn=DBConnection.getConnection();
				PreparedStatement ps=conn.prepareStatement("select distinct branch from subject_details");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
					subjectDetailsPojo.setBranch(rs.getString("branch"));
					
					
					list.add(subjectDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<SubjectDetailsPojo> getYearList(String branch) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		try {
			List<SubjectDetailsPojo> list=new ArrayList<SubjectDetailsPojo>();
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select distinct year from subject_details where branch=?");
			ps.setString(1, branch);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
				subjectDetailsPojo.setYear(rs.getString("year"));
				
				
				list.add(subjectDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SubjectDetailsPojo> getSemList(String year) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		try {
			List<SubjectDetailsPojo> list=new ArrayList<SubjectDetailsPojo>();
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select distinct semester from subject_details where year=?");
			ps.setString(1, year);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
				subjectDetailsPojo.setSemester(rs.getString("semester"));
				
				
				list.add(subjectDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SubjectDetailsPojo> getSubjectList(String branch, String sem,long teacher_id) {
		// TODO Auto-generated method stub
		
	Connection conn=null;
		
		try {
			List<SubjectDetailsPojo> list=new ArrayList<SubjectDetailsPojo>();
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select  subject from teacher_subject_details where branch=? and semester=? and teacher_id=?");
			ps.setString(1, branch);
			ps.setString(2, sem);
			ps.setLong(3, teacher_id);
			ResultSet rs=ps.executeQuery();
			System.out.println("pss fro subjet"+ps);
			while(rs.next()){
				SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
				subjectDetailsPojo.setSubject(rs.getString("subject"));
				
				System.out.println("subject in impl"+rs.getString("subject"));
				list.add(subjectDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addTeacherQuestionDetails(
			QuestionDetailsPojo questionDetailsPojo) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
				try {
					
					/*List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
					conn=DBConnection.getConnection();
					 ps=conn.prepareStatement("select * from teacher_question where subject=?");
					 ps.setString(1, subjectDetailsPojo.getSubject());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()){
						return false;
					}
					else{*/
					conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("insert into teacher_question(branch,year,semester,no_of_module,subject,teacher_id,difficulty_level,difficulty_text,marks) values(?,?,?,?,?,?,?,?,?)");
					
					ps.setString(1, questionDetailsPojo.getBranch());
					ps.setString(2, questionDetailsPojo.getYear());
					ps.setString(3, questionDetailsPojo.getSemester());
					ps.setInt(4, questionDetailsPojo.getNo_of_module());
					ps.setString(5, questionDetailsPojo.getSubject());
					ps.setLong(6, questionDetailsPojo.getTeacher_id());
					ps.setString(7, questionDetailsPojo.getDifficulty_level());
					ps.setString(8, questionDetailsPojo.getDifficulty_text());
					ps.setFloat(9, questionDetailsPojo.getMarks());
					
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
	public boolean addTeacherQuestionDetailsInQuestion(
			QuestionDetailsPojo questionDetailsPojo) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
				try {
					
					/*List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
					conn=DBConnection.getConnection();
					 ps=conn.prepareStatement("select * from teacher_question where subject=?");
					 ps.setString(1, subjectDetailsPojo.getSubject());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()){
						return false;
					}
					else{*/
					conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("insert into question_table(question_id,question,image) values(?,?,?)");
					ps.setLong(1, questionDetailsPojo.getQuestion_id());
					ps.setString(2, questionDetailsPojo.getQuestion());
					ps.setString(3, questionDetailsPojo.getImg());
					
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
	public long getLastQuestionID() {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		long q_id=0;
				try {
					
					conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("select * from teacher_question ORDER BY question_id DESC LIMIT 1");
					ResultSet x=ps.executeQuery();
					while(x.next()){
						q_id=x.getLong("question_id");
						System.out.println("q"+q_id);
					}
					return q_id;
					/*}*/
				} catch (Exception e) {
					e.printStackTrace();
				}
		return 0;
	}

	@Override
	public boolean addTeacherQuestionDetailsInMarksScheme(
			QuestionDetailsPojo questionDetailsPojo) {
		// TODO Auto-generated method stub
		
		
		Connection conn=null;
		PreparedStatement ps=null;
				try {
					
					
					conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("insert into marks_scheme_table(question_id,scheme_type,marks) values(?,?,?)");
					ps.setLong(1, questionDetailsPojo.getQuestion_id());
					ps.setString(2, questionDetailsPojo.getText_type());
					ps.setDouble(3, questionDetailsPojo.getText_marks());
					
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
	public List<QuestionDetailsPojo> getAllQuestion() {
		// TODO Auto-generated method stub
		
		 Connection conn=null;
		 long q_id=0;
			
			try {
				List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
				conn=DBConnection.getConnection();
				//PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
				PreparedStatement ps=conn.prepareStatement("SELECT  *  FROM teacher_question");
				
				ResultSet rs=ps.executeQuery();
				System.out.println("ps"+ps);
				while(rs.next()){
					
					q_id=rs.getLong("question_id");
					System.out.println("in impl quesn id"+q_id);
					QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
					questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
					questionDetailsPojo.setMarks(rs.getFloat("marks"));
					/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
					questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
					questionDetailsPojo.setQuestion(rs.getString("question"));
					questionDetailsPojo.setImg(rs.getString("image"));
					questionDetailsPojo.setMarks(rs.getFloat("marks"));
					questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
					
					//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
					PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
						ps1.setLong(1, q_id);
						ResultSet rs1=ps1.executeQuery();
						System.out.println("ps"+ps1);
						
						while(rs1.next()){
							questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
						}
						
						PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
						ps2.setLong(1, q_id);
						ResultSet rs2=ps2.executeQuery();
						System.out.println("ps"+ps2);
						
						while(rs2.next()){
							questionDetailsPojo.setQuestion(rs2.getString("question"));
							questionDetailsPojo.setImg(rs2.getString("image"));
						}
						list.add(questionDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		return null;
	}

	@Override
	public int getModuleBySubject(String subject) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
				try {
					
					
					conn=DBConnection.getConnection();
					 ps=conn.prepareStatement("select no_of_module from teacher_subject_details where subject=?");
					 ps.setString(1, subject);
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()){
						int count=rs.getInt("no_of_module");
						System.out.println("count"+count);
						return count;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		
		return 0;
	}

	@Override
	public List<QuestionDetailsPojo> getEasyQuestionByOsm(String subject, int osm) {
		// TODO Auto-generated method stub
		
		long q_id=0;
		 Connection conn=null;
		
			try {
				List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
				conn=DBConnection.getConnection();
				//PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
				PreparedStatement ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=?");
				ps.setString(1, subject);
				ps.setInt(2, osm);
				ps.setString(3,"Easy");
				
				ResultSet rs=ps.executeQuery();
				System.out.println("ps"+ps);
				while(rs.next()){
					
					q_id=rs.getLong("question_id");
					System.out.println("in impl quesn id"+q_id);
					QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
					questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
					questionDetailsPojo.setMarks(rs.getFloat("marks"));
					/*questionDetailsPojo.setQuestion(rs.getString("question"));
					questionDetailsPojo.setImg(rs.getString("image"));
					questionDetailsPojo.setMarks(rs.getFloat("marks"));
					questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
					//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
					PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
					ps1.setLong(1, q_id);
					ResultSet rs1=ps1.executeQuery();
					System.out.println("ps"+ps1);
					
					while(rs1.next()){
						questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
					}
					
					PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
					ps2.setLong(1, q_id);
					ResultSet rs2=ps2.executeQuery();
					System.out.println("ps"+ps2);
					
					while(rs2.next()){
						questionDetailsPojo.setQuestion(rs2.getString("question"));
						questionDetailsPojo.setImg(rs2.getString("image"));
					}
					
					
					
					list.add(questionDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<QuestionDetailsPojo> getMediumQuestionByOsm(String subject, int osm) {
		// TODO Auto-generated method stub
		long q_id=0;
		 Connection conn=null;
		
		try {
			List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
			conn=DBConnection.getConnection();
			//PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
			PreparedStatement ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=?");
			ps.setString(1, subject);
			ps.setInt(2, osm);
			ps.setString(3,"Medium");
			
			ResultSet rs=ps.executeQuery();
			System.out.println("ps"+ps);
			while(rs.next()){
				
				q_id=rs.getLong("question_id");
				System.out.println("in impl quesn id"+q_id);
				QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setQuestion(rs.getString("question"));
				questionDetailsPojo.setImg(rs.getString("image"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
				
				//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
					ps1.setLong(1, q_id);
					ResultSet rs1=ps1.executeQuery();
					System.out.println("ps"+ps);
					
					while(rs1.next()){
						questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
					}
					
					PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
					ps2.setLong(1, q_id);
					ResultSet rs2=ps2.executeQuery();
					System.out.println("ps"+ps2);
					
					while(rs2.next()){
						questionDetailsPojo.setQuestion(rs2.getString("question"));
						questionDetailsPojo.setImg(rs2.getString("image"));
					}
				list.add(questionDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<QuestionDetailsPojo> getHardQuestionByOsm(String subject, int osm) {
		// TODO Auto-generated method stub
		
		long q_id=0;
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		
		try {
			List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
			conn=DBConnection.getConnection();
			//PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
		    ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=?");
			ps.setString(1, subject);
			ps.setInt(2, osm);
			ps.setString(3,"Difficult");
			
			rs=ps.executeQuery();
			System.out.println("ps"+ps);
			while(rs.next()){
				
				q_id=rs.getLong("question_id");
				System.out.println("in impl quesn id"+q_id);
				QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setQuestion(rs.getString("question"));
				questionDetailsPojo.setImg(rs.getString("image"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
				
				//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				 ps=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
					ps.setLong(1, q_id);
					rs=ps.executeQuery();
					System.out.println("ps"+ps);
					
					while(rs.next()){
						questionDetailsPojo.setText_type("scheme_type");
					}
					
					ps=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
					ps.setLong(1, q_id);
					rs=ps.executeQuery();
					System.out.println("ps"+ps);
					
					while(rs.next()){
						questionDetailsPojo.setQuestion(rs.getString("question"));
						questionDetailsPojo.setImg(rs.getString("image"));
					}
				
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setQuestion(rs.getString("question"));
				questionDetailsPojo.setImg(rs.getString("image"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				*/
				//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				
				list.add(questionDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<QuestionDetailsPojo> getEasyQuestionByTsm(String subject,
			int tsm) {
		// TODO Auto-generated method stub
		
		long q_id=0;
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
			
			try {
				List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
				conn=DBConnection.getConnection();
				//PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
				ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=?");
				ps.setString(1, subject);
				ps.setInt(2, tsm);
				ps.setString(3,"Easy");
				
				rs=ps.executeQuery();
				System.out.println("ps"+ps);
				while(rs.next()){
					
					q_id=rs.getLong("question_id");
					System.out.println("in impl quesn id"+q_id);
					QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
					questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
					questionDetailsPojo.setMarks(rs.getFloat("marks"));
					/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
					questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
					questionDetailsPojo.setQuestion(rs.getString("question"));
					questionDetailsPojo.setImg(rs.getString("image"));
					questionDetailsPojo.setMarks(rs.getFloat("marks"));
					questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
					
					//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
					 ps=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
						ps.setLong(1, q_id);
						rs=ps.executeQuery();
						System.out.println("ps"+ps);
						
						while(rs.next()){
							questionDetailsPojo.setText_type(rs.getString("scheme_type"));
						}
						
						ps=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
						ps.setLong(1, q_id);
						rs=ps.executeQuery();
						System.out.println("ps"+ps);
						
						while(rs.next()){
							questionDetailsPojo.setQuestion(rs.getString("question"));
							questionDetailsPojo.setImg(rs.getString("image"));
						}
					/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
					questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
					questionDetailsPojo.setQuestion(rs.getString("question"));
					questionDetailsPojo.setImg(rs.getString("image"));
					questionDetailsPojo.setMarks(rs.getFloat("marks"));
					questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
					
					//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
					
					list.add(questionDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public List<QuestionDetailsPojo> getMediumQuestionByTsm(String subject,
			int tsm) {
		// TODO Auto-generated method stub
		
		long q_id=0;
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		
		try {
			List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
			conn=DBConnection.getConnection();
			//PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
			ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=?");
			ps.setString(1, subject);
			ps.setInt(2, tsm);
			ps.setString(3,"Medium");
			
			rs=ps.executeQuery();
			System.out.println("ps"+ps);
			while(rs.next()){
				
				q_id=rs.getLong("question_id");
				System.out.println("in impl quesn id"+q_id);
				QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setQuestion(rs.getString("question"));
				questionDetailsPojo.setImg(rs.getString("image"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
				
				//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				 ps=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
					ps.setLong(1, q_id);
					rs=ps.executeQuery();
					System.out.println("ps"+ps);
					
					while(rs.next()){
						questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					}
					
					ps=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
					ps.setLong(1, q_id);
					rs=ps.executeQuery();
					System.out.println("ps"+ps);
					
					while(rs.next()){
						questionDetailsPojo.setQuestion(rs.getString("question"));
						questionDetailsPojo.setImg(rs.getString("image"));
					}
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setQuestion(rs.getString("question"));
				questionDetailsPojo.setImg(rs.getString("image"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				*/
				//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				
				list.add(questionDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<QuestionDetailsPojo> getHardQuestionByTsm(String subject,
			int tsm) {
		// TODO Auto-generated method stub
		
		
		long q_id=0;
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		
		try {
			List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
			conn=DBConnection.getConnection();
			//PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
			ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=?");
			ps.setString(1, subject);
			ps.setInt(2, tsm);
			ps.setString(3,"Difficult");
			
			 rs=ps.executeQuery();
			System.out.println("ps"+ps);
			while(rs.next()){
				
				q_id=rs.getLong("question_id");
				System.out.println("in impl quesn id"+q_id);
				QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setQuestion(rs.getString("question"));
				questionDetailsPojo.setImg(rs.getString("image"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
				
				//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				 ps=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
					ps.setLong(1, q_id);
					rs=ps.executeQuery();
					System.out.println("ps"+ps);
					
					while(rs.next()){
						questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					}
					
					ps=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
					ps.setLong(1, q_id);
					rs=ps.executeQuery();
					System.out.println("ps"+ps);
					
					while(rs.next()){
						questionDetailsPojo.setQuestion(rs.getString("question"));
						questionDetailsPojo.setImg(rs.getString("image"));
					}
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
				questionDetailsPojo.setQuestion(rs.getString("question"));
				questionDetailsPojo.setImg(rs.getString("image"));
				questionDetailsPojo.setMarks(rs.getFloat("marks"));
				questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
				//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
				//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
				
				list.add(questionDetailsPojo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<QuestionDetailsPojo> getQuestion(long q_id) {
		// TODO Auto-generated method stub
		
		 Connection conn=null;
			
			try {
				List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
				conn=DBConnection.getConnection();
				//PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
				PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id,teacher_question.marks, question_table.question,  question_table.image  FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id where teacher_question.question_id=?");
				
				ps.setLong(1, q_id);
				
				
				ResultSet rs=ps.executeQuery();
				System.out.println("ps"+ps);
				while(rs.next()){
					
					QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
					questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
					questionDetailsPojo.setQuestion(rs.getString("question"));
					questionDetailsPojo.setImg(rs.getString("image"));
					questionDetailsPojo.setMarks(rs.getFloat("marks"));
					questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					questionDetailsPojo.setText_marks(rs.getDouble("marks"));
					
					//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
					//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
					
					list.add(questionDetailsPojo);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public boolean saveCustoizeQuestion(List<CustomizePojo> queList,String set_status) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		int x=0;
				try {
					for(int i=0;i<queList.size();i++)
					{
					conn=DBConnection.getConnection();
				    ps=conn.prepareStatement("insert into customizationQuestion_table(question_id,marks,question_status,set_status) values(?,?,?,?)");
					ps.setLong(1, queList.get(i).getQuestion_id());
					ps.setLong(2, queList.get(i).getQuestion_mark());
					ps.setString(3,queList.get(i).getQuestion_status());
					ps.setString(4,set_status);
					x=ps.executeUpdate();
					}
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
	 public List<QuestionDetailsPojo> getEasyQuestionBytemp2(String subject,int mark,int fmod,int tmod) {
	  // TODO Auto-generated method stub
	  
		long q_id=0;
		 Connection conn=null;
	   
	   try {
	    List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
	    conn=DBConnection.getConnection();
	    //PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
	   PreparedStatement ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=? and no_of_module BETWEEN ? and ?");
	    ps.setString(1, subject);
	    ps.setInt(2, mark);
	    ps.setString(3,"Easy");
	    ps.setInt(4, fmod);
	    ps.setInt(5, tmod);
	    
	    ResultSet rs=ps.executeQuery();
	    System.out.println("ps"+ps);
	    while(rs.next()){
	     

			q_id=rs.getLong("question_id");
			System.out.println("in impl quesn id"+q_id);
			QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
			questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
			questionDetailsPojo.setMarks(rs.getFloat("marks"));
			/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
			questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
			questionDetailsPojo.setQuestion(rs.getString("question"));
			questionDetailsPojo.setImg(rs.getString("image"));
			questionDetailsPojo.setMarks(rs.getFloat("marks"));
			questionDetailsPojo.setText_type(rs.getString("scheme_type"));
			questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
			
			//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
			//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
			PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
				ps1.setLong(1, q_id);
				ResultSet	rs1=ps1.executeQuery();
				System.out.println("ps"+ps);
				
				while(rs1.next()){
					questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
				}
				
				PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
				ps2.setLong(1, q_id);
				ResultSet rs2=ps2.executeQuery();
				System.out.println("ps"+ps2);
				
				while(rs2.next()){
					questionDetailsPojo.setQuestion(rs2.getString("question"));
					questionDetailsPojo.setImg(rs2.getString("image"));
				}
	     
	     //questionDetailsPojo.setText_type(rs.getString("scheme_type"));
	     //questionDetailsPojo.setText_marks(rs.getDouble("marks"));
	     
	     list.add(questionDetailsPojo);
	    }
	    System.out.println(" easy list in impl"+list.size());
	    return list;
	   
	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	return null;
	 }
	
	@Override
	 public List<QuestionDetailsPojo> getMediumQuestionBytemp2(String subject,int mark,int fmod,int tmod) {
	  // TODO Auto-generated method stub
		long q_id=0;
		 Connection conn=null;
		 
		 

	  try {
	   List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
	   conn=DBConnection.getConnection();
	   //PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
	   PreparedStatement ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=? and no_of_module BETWEEN ? and ?");
	   ps.setString(1, subject);
	   ps.setInt(2, mark);
	   ps.setString(3,"Medium");
	   ps.setInt(4, fmod);
	    ps.setInt(5, tmod);
	    
	    ResultSet rs=ps.executeQuery();
	   System.out.println("ps"+ps);
	   while(rs.next()){
		   

			q_id=rs.getLong("question_id");
			System.out.println("in impl quesn id"+q_id);
			QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
			questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
			questionDetailsPojo.setMarks(rs.getFloat("marks"));
			/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
			questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
			questionDetailsPojo.setQuestion(rs.getString("question"));
			questionDetailsPojo.setImg(rs.getString("image"));
			questionDetailsPojo.setMarks(rs.getFloat("marks"));
			questionDetailsPojo.setText_type(rs.getString("scheme_type"));
			questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
			
			//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
			//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
			PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
				ps1.setLong(1, q_id);
				ResultSet rs1=ps1.executeQuery();
				System.out.println("ps"+ps);
				
				while(rs1.next()){
					questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
				}
				
				PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
				ps2.setLong(1, q_id);
				ResultSet rs2=ps2.executeQuery();
				System.out.println("ps"+ps2);
				
				while(rs2.next()){
					questionDetailsPojo.setQuestion(rs2.getString("question"));
					questionDetailsPojo.setImg(rs2.getString("image"));
				}
	    
	    /*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
	    questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
	    questionDetailsPojo.setQuestion(rs.getString("question"));
	    questionDetailsPojo.setImg(rs.getString("image"));
	    questionDetailsPojo.setMarks(rs.getFloat("marks"));
	    questionDetailsPojo.setText_type(rs.getString("scheme_type"));
		questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
	    
	    //questionDetailsPojo.setText_type(rs.getString("scheme_type"));
	    //questionDetailsPojo.setText_marks(rs.getDouble("marks"));
	    
	    list.add(questionDetailsPojo);
	   }
	   System.out.println(" medium list in impl"+list.size());
	   return list;
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  
	  
	  
	  return null;
	 }

	 @Override
	 public List<QuestionDetailsPojo> getHardQuestionBytemp2(String subject,int mark,int fmod,int tmod) {
	  // TODO Auto-generated method stub
	  
		 long q_id=0;
		 Connection conn=null;
		 	  
	  try {
		   List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
		   conn=DBConnection.getConnection();
		   //PreparedStatement ps=conn.prepareStatement("SELECT  teacher_question.question_id, question_table.question,  question_table.image,marks_scheme_table.scheme_type,marks_scheme_table.marks FROM teacher_question INNER JOIN  question_table ON  question_table.question_id =  teacher_question.question_id INNER JOIN marks_scheme_table ON marks_scheme_table.question_id=teacher_question.question_id");
		   PreparedStatement ps=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and teacher_question.marks=? and difficulty_text=? and no_of_module BETWEEN ? and ?");
		   ps.setString(1, subject);
		   ps.setInt(2, mark);
		   ps.setString(3,"Difficult");
		   ps.setInt(4, fmod);
		   ps.setInt(5, tmod);
		    
		   ResultSet rs=ps.executeQuery();
		   System.out.println("ps"+ps);
		   while(rs.next()){
	    

			q_id=rs.getLong("question_id");
			System.out.println("in impl quesn id"+q_id);
			QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
			questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
			questionDetailsPojo.setMarks(rs.getFloat("marks"));
			/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
			questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
			questionDetailsPojo.setQuestion(rs.getString("question"));
			questionDetailsPojo.setImg(rs.getString("image"));
			questionDetailsPojo.setMarks(rs.getFloat("marks"));
			questionDetailsPojo.setText_type(rs.getString("scheme_type"));
			questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
			
			//questionDetailsPojo.setText_type(rs.getString("scheme_type"));
			//questionDetailsPojo.setText_marks(rs.getDouble("marks"));
			PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
				ps1.setLong(1, q_id);
				ResultSet rs1=ps1.executeQuery();
				System.out.println("ps"+ps1);
				
				while(rs1.next()){
					questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
				}
				
				PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
				ps2.setLong(1, q_id);
				ResultSet rs2=ps2.executeQuery();
				System.out.println("ps"+ps2);
				
				while(rs2.next()){
					questionDetailsPojo.setQuestion(rs2.getString("question"));
					questionDetailsPojo.setImg(rs2.getString("image"));
				}
	    /*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
	    questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
	    questionDetailsPojo.setQuestion(rs.getString("question"));
	    questionDetailsPojo.setImg(rs.getString("image"));
	    questionDetailsPojo.setMarks(rs.getFloat("marks"));
	    questionDetailsPojo.setText_type(rs.getString("scheme_type"));
		questionDetailsPojo.setText_marks(rs.getDouble("marks"));*/
	    
	    //questionDetailsPojo.setText_type(rs.getString("scheme_type"));
	    //questionDetailsPojo.setText_marks(rs.getDouble("marks"));
	    
	    list.add(questionDetailsPojo);
	   }
	   System.out.println(" dificult list in impl"+list.size());
	   return list;
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  
	  
	  return null;
	 }

	@Override
	public boolean addSet1Details(Set<QuestionDetailsPojo> tmp1QuestionList10,
			PaperSetDetailsPojo paper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CustomizePojo> getCustomizeDetailsFor30Marks(String subject,int fmod,int tmod) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		int q_marks=0;
		int count=1;
		long q_id=0;
		
		try {
			List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
			List<CustomizePojo> list1=new ArrayList<CustomizePojo>();
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select   marks from customizationquestion_table ");
			ResultSet rs=ps.executeQuery();
			System.out.println("ps"+ps);
			while(rs.next()){
				
				q_marks=rs.getInt("marks");
				System.out.println("marks in mpl"+q_marks);
				
					PreparedStatement pstm=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and marks=? and no_of_module BETWEEN ? and ? and  question_id NOT IN   (SELECT old_qid FROM customizationquestion_table where teacher_question.question_id=customizationquestion_table.old_qid)   ORDER BY rand()  limit 1 ");
					   pstm.setString(1, subject);
					   pstm.setInt(2, q_marks);
					   pstm.setInt(3, fmod);
					    pstm.setInt(4, tmod);
					    ResultSet rst=pstm.executeQuery();
					  System.out.println("ps"+pstm);
					   while(rst.next()){
					    

							q_id=rst.getLong("question_id");
							System.out.println("in impl quesn id"+q_id);
							QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion_id(rst.getLong("question_id"));
							questionDetailsPojo.setMarks(rst.getFloat("marks"));
					
							    PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
								ps1.setLong(1, q_id);
								ResultSet rs1=ps1.executeQuery();
								
								while(rs1.next()){
									questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
								}
								
								PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
								ps2.setLong(1, q_id);
								ResultSet rs2=ps2.executeQuery();
								
								while(rs2.next()){
									questionDetailsPojo.setQuestion(rs2.getString("question"));
									questionDetailsPojo.setImg(rs2.getString("image"));
								}
								// list.add(questionDetailsPojo);
								 
								 System.out.println("all list"+list.size());
								   PreparedStatement pstm1=conn.prepareStatement("update customizationquestion_table set question=?, mark_scheme=? , image=? ,old_qid=? where cust_qid=?");
								   pstm1.setString(1, questionDetailsPojo.getQuestion());
								   pstm1.setString(2, questionDetailsPojo.getText_type());
								   pstm1.setString(3, questionDetailsPojo.getImg());
								   pstm1.setLong(4, questionDetailsPojo.getQuestion_id());
								   pstm1.setInt(5, count);
								   int rs3=pstm1.executeUpdate();
								   if( rs3>0)
								   {
									   count++;
								   }
								   System.out.println("pstm update"+pstm1);
					   }
					
			}

			PreparedStatement pstmF=conn.prepareStatement("SELECT  *  FROM customizationquestion_table");
            ResultSet rstF=pstmF.executeQuery();
            while(rstF.next()){
            	CustomizePojo cst=new CustomizePojo();
            	cst.setQuestion_id(rstF.getLong("question_id"));
            	cst.setQuestion_mark(rstF.getLong("marks"));
            	cst.setQuestion_status(rstF.getString("question_status"));
            	cst.setImage(rstF.getString("image"));
            	cst.setMark_scheme(rstF.getString("mark_scheme"));
            	cst.setQuestion(rstF.getString("question"));
            	list1.add(cst);
            }
            System.out.println("final custiom list size"+list1);
			return list1;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
		return null;
	}

	@Override
	public List<CustomizePojo> getustomListSet1(String set_status) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		try{
			List<CustomizePojo> list1=new ArrayList<CustomizePojo>();
		
			conn=DBConnection.getConnection();

		PreparedStatement pstmF=conn.prepareStatement("SELECT  *  FROM customizationquestion_table where set_status=?");
		pstmF.setString(1, set_status);
        ResultSet rstF=pstmF.executeQuery();
        System.out.println("pstm for set1"+pstmF);
        while(rstF.next()){
        	CustomizePojo cst=new CustomizePojo();
        	cst.setQuestion_id(rstF.getLong("question_id"));
        	cst.setQuestion_mark(rstF.getLong("marks"));
        	cst.setQuestion_status(rstF.getString("question_status"));
        	System.out.println(rstF.getString("question_status"));
        	cst.setImage(rstF.getString("image"));
        	cst.setMark_scheme(rstF.getString("mark_scheme"));
        	cst.setQuestion(rstF.getString("question"));
        	list1.add(cst);
        }
	
        System.out.println("final custiom list size set1::"+list1.size());
		return list1;
	} catch (Exception e) {
		e.printStackTrace();
	}


		return null;
	}

	@Override
	public List<CustomizePojo> getCustomizeDetailsFor80Marks(String subject) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		int q_marks=0;
		int count=1;
		long q_id=0;
		
		try {
			List<QuestionDetailsPojo> list=new ArrayList<QuestionDetailsPojo>();
			List<CustomizePojo> list1=new ArrayList<CustomizePojo>();
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select   marks from customizationquestion_table ");
			ResultSet rs=ps.executeQuery();
			System.out.println("ps"+ps);
			while(rs.next()){
				
				q_marks=rs.getInt("marks");
				System.out.println("marks in mpl"+q_marks);
				
					PreparedStatement pstm=conn.prepareStatement("SELECT  *  FROM teacher_question where subject=? and marks=?  and  question_id NOT IN   (SELECT old_qid FROM customizationquestion_table where teacher_question.question_id=customizationquestion_table.old_qid)   ORDER BY rand()  limit 1 ");
					   pstm.setString(1, subject);
					   pstm.setInt(2, q_marks);
					 
					    ResultSet rst=pstm.executeQuery();
					  System.out.println("ps"+pstm);
					   while(rst.next()){
					    

							q_id=rst.getLong("question_id");
							System.out.println("in impl quesn id"+q_id);
							QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion_id(rst.getLong("question_id"));
							questionDetailsPojo.setMarks(rst.getFloat("marks"));
					
							    PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
								ps1.setLong(1, q_id);
								ResultSet rs1=ps1.executeQuery();
								
								while(rs1.next()){
									questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
								}
								
								PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
								ps2.setLong(1, q_id);
								ResultSet rs2=ps2.executeQuery();
								
								while(rs2.next()){
									questionDetailsPojo.setQuestion(rs2.getString("question"));
									questionDetailsPojo.setImg(rs2.getString("image"));
								}
								// list.add(questionDetailsPojo);
								 
								 System.out.println("all list"+list.size());
								   PreparedStatement pstm1=conn.prepareStatement("update customizationquestion_table set question=?, mark_scheme=? , image=? ,old_qid=? where cust_qid=?");
								   pstm1.setString(1, questionDetailsPojo.getQuestion());
								   pstm1.setString(2, questionDetailsPojo.getText_type());
								   pstm1.setString(3, questionDetailsPojo.getImg());
								   pstm1.setLong(4, questionDetailsPojo.getQuestion_id());
								   pstm1.setInt(5, count);
								   int rs3=pstm1.executeUpdate();
								   if( rs3>0)
								   {
									   count++;
								   }
								   System.out.println("pstm update"+pstm1);
					   }
					
			}

			PreparedStatement pstmF=conn.prepareStatement("SELECT  *  FROM customizationquestion_table");
            ResultSet rstF=pstmF.executeQuery();
            while(rstF.next()){
            	CustomizePojo cst=new CustomizePojo();
            	cst.setQuestion_id(rstF.getLong("question_id"));
            	cst.setQuestion_mark(rstF.getLong("marks"));
            	cst.setQuestion_status(rstF.getString("question_status"));
            	cst.setImage(rstF.getString("image"));
            	cst.setMark_scheme(rstF.getString("mark_scheme"));
            	cst.setQuestion(rstF.getString("question"));
            	list1.add(cst);
            }
            System.out.println("final custiom list size"+list1);
			return list1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	
		
	}

	@Override
	public boolean deleteAllFromCustomize() {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("TRUNCATE TABLE customizationquestion_table");
			
			int rs=ps.executeUpdate();
			
			if(rs>0)
			{
			return true; 	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteQuestion(long question_id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		try {
			conn=DBConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("DELETE teacher_question, marks_scheme_table, question_table FROM teacher_question INNER JOIN marks_scheme_table INNER JOIN question_table WHERE teacher_question.question_id = marks_scheme_table.question_id AND marks_scheme_table.question_id = question_table.question_id AND teacher_question.question_id=?");
			ps.setLong(1, question_id);
			int rs=ps.executeUpdate();
			System.out.println("..."+ps);
			if(rs>0)
			{
			return true; 	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	@Override
	 public QuestionDetailsPojo getQuestionDetails(Long question_id) {
	  // TODO Auto-generated method stub
	  
		long q_id=0;
		 Connection conn=null;
	   
	   try {
	    conn=DBConnection.getConnection();
	    PreparedStatement ps=conn.prepareStatement("SELECT  *  FROM teacher_question where question_id=?");
	    ps.setLong(1, question_id);
	    QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
	    
	    ResultSet rs=ps.executeQuery();
	    System.out.println("ps"+ps);
	    while(rs.next()){
			q_id=rs.getLong("question_id");
			System.out.println("in impl quesn id"+q_id);
			
			questionDetailsPojo.setQuestion_id(rs.getLong("question_id"));
			questionDetailsPojo.setMarks(rs.getFloat("marks"));
			PreparedStatement ps1=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(scheme_type,marks))  AS scheme_type FROM marks_scheme_table where question_id=? GROUP BY question_id");
				ps1.setLong(1, q_id);
				ResultSet	rs1=ps1.executeQuery();
				System.out.println("ps"+ps1);
				
				while(rs1.next()){
					questionDetailsPojo.setText_type(rs1.getString("scheme_type"));
				}
				
				PreparedStatement ps2=conn.prepareStatement("SELECT question_id, GROUP_CONCAT(concat(question))  AS question,GROUP_CONCAT(concat(image))  AS image FROM question_table where question_id=? GROUP BY question_id");
				ps2.setLong(1, q_id);
				ResultSet rs2=ps2.executeQuery();
				System.out.println("ps"+ps2);
				
				while(rs2.next()){
					questionDetailsPojo.setQuestion(rs2.getString("question"));
					questionDetailsPojo.setImg(rs2.getString("image"));
				}
	  
	    }
	    return questionDetailsPojo;
	   
	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	return null;
	 }

	@Override
	public PaperSetEncryptPojo getFileDetails(String pdf) {
		// TODO Auto-generated method stub
		
		
		Connection conn=null;
		
		try{
			PaperSetEncryptPojo cst=new PaperSetEncryptPojo();
		
			conn=DBConnection.getConnection();

		PreparedStatement pstmF=conn.prepareStatement("SELECT  *  FROM paper_set_details where set_name=?");
		pstmF.setString(1, pdf);
        ResultSet rstF=pstmF.executeQuery();
        System.out.println("pstm for set1"+pstmF);
        while(rstF.next()){
        	cst.setDate(rstF.getString("date"));
        	cst.setSet_name(rstF.getString("set_name"));
        	cst.setSubject(rstF.getString("subject"));
        	cst.setTime(rstF.getDouble("time"));
        	System.out.println("time in impl"+rstF.getDouble("time"));
        	cst.setTeacher_id(rstF.getLong("teacher_id"));
        	
        	
        }
	
		return cst;
	} catch (Exception e) {
		e.printStackTrace();
	}


		return null;
	}
	
}
