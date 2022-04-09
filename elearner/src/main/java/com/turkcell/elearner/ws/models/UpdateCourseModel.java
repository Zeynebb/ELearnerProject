package com.turkcell.elearner.ws.models;

import lombok.Data;

@Data
public class UpdateCourseModel {
	
	private String courseId;
	
	private String courseName;

	private String description;

	private double price;

}
