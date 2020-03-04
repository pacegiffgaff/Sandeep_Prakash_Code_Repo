package com.giffgaff.app.model;

import java.util.List;

public class UserSurvey {

	private int id;
	private String title;
	private String description;
	private List<Questions> questions;

	public UserSurvey(int id, String title, String description, List<Questions> questions) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.questions = questions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

}
