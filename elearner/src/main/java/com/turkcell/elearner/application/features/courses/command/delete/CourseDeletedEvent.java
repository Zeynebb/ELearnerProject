package com.turkcell.elearner.application.features.courses.command.delete;

import lombok.Data;

@Data
public class CourseDeletedEvent {
	
	private String courseId;

}
