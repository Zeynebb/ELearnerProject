package com.turkcell.elearner.application.features.courses.command.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpdatedEvent {
	
	private String courseId;

	private String courseName;

	private String description;

	private double price;

}
