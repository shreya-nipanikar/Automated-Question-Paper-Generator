package com.fuzzyAQP.pojo;

public class QuestionDetailsPojo {
	
	
	
	private long sub_id;
	
	private String branch;
	
    private String year;
	
	private String semester;
	
	private int no_of_module;
 
	private String subject;
	
	private long teacher_id;
	
	private long question_id;
	
	private String difficulty_level;
	
	private String difficulty_text;
	
	private String text_type;
	
	private double text_marks;

	private String img;
	
	private String question;
	
	private String mathematical_formula;
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMathematical_formula() {
		return mathematical_formula;
	}

	public void setMathematical_formula(String mathematical_formula) {
		this.mathematical_formula = mathematical_formula;
	}

	public String getDifficulty_text() {
		return difficulty_text;
	}

	public void setDifficulty_text(String difficulty_text) {
		this.difficulty_text = difficulty_text;
	}

	private float marks;
	
	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public String getDifficulty_level() {
		return difficulty_level;
	}

	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}

	public long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
	
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
	

	public String getText_type() {
		return text_type;
	}

	public void setText_type(String text_type) {
		this.text_type = text_type;
	}

	public double getText_marks() {
		return text_marks;
	}

	public void setText_marks(double text_marks) {
		this.text_marks = text_marks;
	}
	
	
	
	
	

}
