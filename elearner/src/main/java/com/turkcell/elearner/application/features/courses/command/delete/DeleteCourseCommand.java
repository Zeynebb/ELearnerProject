package com.turkcell.elearner.application.features.courses.command.delete;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteCourseCommand {
	
	@TargetAggregateIdentifier
	private String courseId;

}
