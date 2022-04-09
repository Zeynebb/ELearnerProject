package com.turkcell.elearner.application.features.courses.command.update;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UpdateCourseAggregate {

	@TargetAggregateIdentifier
	private String courseId;

	private String courseName;

	private String description;

	private double price;

	public UpdateCourseAggregate() {

	}

	@CommandHandler
	public UpdateCourseAggregate(UpdateCourseCommand updateCourseCommand) {

		CourseUpdatedEvent courseUpdatedEvent = new CourseUpdatedEvent();

		BeanUtils.copyProperties(updateCourseCommand, courseUpdatedEvent);
		AggregateLifecycle.apply(courseUpdatedEvent);

	}

	@EventSourcingHandler
	public void on(CourseUpdatedEvent courseUpdatedEvent) {
		this.courseId = courseUpdatedEvent.getCourseId();
		this.courseName = courseUpdatedEvent.getCourseName();
		this.description = courseUpdatedEvent.getDescription();
		this.price = courseUpdatedEvent.getPrice();
	}

}
