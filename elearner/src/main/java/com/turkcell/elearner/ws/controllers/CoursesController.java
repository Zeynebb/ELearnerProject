package com.turkcell.elearner.ws.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.elearner.application.features.courses.command.create.CreateCourseCommand;
import com.turkcell.elearner.application.features.courses.command.delete.DeleteCourseCommand;
import com.turkcell.elearner.application.features.courses.command.update.UpdateCourseCommand;
import com.turkcell.elearner.ws.models.CreateCourseModel;
import com.turkcell.elearner.ws.models.DeleteCourseModel;
import com.turkcell.elearner.ws.models.UpdateCourseModel;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

	private CommandGateway commandGateway;

	@Autowired
	public CoursesController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping("/create")
	public void createCourse(@RequestBody CreateCourseModel createCourseModel) {

		CreateCourseCommand createCourseCommand = CreateCourseCommand.builder()
				.courseName(createCourseModel.getCourseName()).description(createCourseModel.getDescription())
				.price(createCourseModel.getPrice()).build();

		createCourseCommand.setCourseId(UUID.randomUUID().toString());

		this.commandGateway.sendAndWait(createCourseCommand);
	}

	@PutMapping("/update")
	public void updateCourse(@RequestBody UpdateCourseModel updateCourseModel) {

		UpdateCourseCommand updateCourseCommand = UpdateCourseCommand.builder()
				.courseId(updateCourseModel.getCourseId()).courseName(updateCourseModel.getCourseName())
				.description(updateCourseModel.getDescription()).price(updateCourseModel.getPrice()).build();

		this.commandGateway.sendAndWait(updateCourseCommand);
	}

	@DeleteMapping("/delete")
	public void deleteCourse(@RequestBody DeleteCourseModel deleteCourseModel) {

		DeleteCourseCommand deleteCourseCommand = DeleteCourseCommand.builder()
				.courseId(deleteCourseModel.getCourseId()).build();

		this.commandGateway.sendAndWait(deleteCourseCommand);

	}

}
