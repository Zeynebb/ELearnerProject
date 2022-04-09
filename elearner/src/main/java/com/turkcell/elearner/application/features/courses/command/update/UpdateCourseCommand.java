package com.turkcell.elearner.application.features.courses.command.update;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCourseCommand {
	
	@TargetAggregateIdentifier
	private String courseId;

	private String courseName;

	private String description;

	private double price;

}
