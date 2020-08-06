package com.fuzzyAQP.pojo;

public class SubjectDetailsPojo {
	
	
	
	private long sub_id;
	
	private String branch;
	
    private String year;
	
	private String semester;
	
	private int no_of_module;
 
	private String subject;
	
	private long teacher_id;
	
	
	public long getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getNo_of_module() {
		return no_of_module;
	}

	public void setNo_of_module(int no_of_module) {
		this.no_of_module = no_of_module;
	}

	public long getSub_id() {
		return sub_id;
	}

	public void setSub_id(long sub_id) {
		this.sub_id = sub_id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	
	
	
	
	
	

}
