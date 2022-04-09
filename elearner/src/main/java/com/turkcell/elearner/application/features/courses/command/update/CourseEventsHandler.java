package com.turkcell.elearner.application.features.courses.command.update;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.turkcell.elearner.domain.Course;
import com.turkcell.elearner.persistence.CourseRepository;

@Component("updateCourseEventHandler")
public class CourseEventsHandler {
	
	private CourseRepository courseRepository;

	@Autowired
	public CourseEventsHandler(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@EventHandler
	public void on(CourseUpdatedEvent courseUpdatedEvent) {
		
		Course course = new Course();
		
		BeanUtils.copyProperties(courseUpdatedEvent, course);
		this.courseRepository.save(course);
		
	}
	

}
