package com.turkcell.elearner.ws.models;


import lombok.Data;

@Data
public class CreateCourseModel {
	
	private String courseName;

	private String description;

	private double price;

}
