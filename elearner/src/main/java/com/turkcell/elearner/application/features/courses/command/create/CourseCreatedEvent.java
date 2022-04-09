package com.turkcell.elearner.application.features.courses.command.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreatedEvent {
	
	private String courseId;

	private String courseName;

	private String description;

	private double price;

}
