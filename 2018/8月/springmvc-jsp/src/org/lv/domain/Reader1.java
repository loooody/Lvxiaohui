package org.lv.domain;

import java.util.List;

public class Reader1 {
	private boolean reader;
	private List<String> courses;
	
	public boolean isReader() {
		return reader;
	}

	public void setReader(boolean reader) {
		this.reader = reader;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public Reader1() {}
	
	
}
