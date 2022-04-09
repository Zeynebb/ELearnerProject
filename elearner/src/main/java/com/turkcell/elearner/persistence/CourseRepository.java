package com.turkcell.elearner.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.elearner.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
