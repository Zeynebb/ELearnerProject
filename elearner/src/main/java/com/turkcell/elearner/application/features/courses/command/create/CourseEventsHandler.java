package com.turkcell.elearner.application.features.courses.command.create;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.turkcell.elearner.domain.Course;
import com.turkcell.elearner.persistence.CourseRepository;

@Component("createCourseEventHandler")
public class CourseEventsHandler {

	private CourseRepository courseRepository;

	@Autowired
	public CourseEventsHandler(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@EventHandler
	public void on(CourseCreatedEvent courseCreatedEvent) {

		Course course = new Course();

		BeanUtils.copyProperties(courseCreatedEvent, course);
		this.courseRepository.save(course);
	}

}
