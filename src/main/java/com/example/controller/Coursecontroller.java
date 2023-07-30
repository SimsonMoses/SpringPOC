package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Course;
import com.example.service.CourseserviceImpl;

@RestController
@EnableAutoConfiguration
@RequestMapping("course")
public class Coursecontroller {

	@Autowired
	private CourseserviceImpl courseservice;

	@PostMapping(value = "add")
	public Course saveOrUpdateCourse(@RequestBody Course course) {
		System.out.println(course);
		return courseservice.addCourse(course);
	}

	@PostMapping("addCourseAsList")
	public List<Course> addAllCourse(@RequestBody List<Course> courses){
		return courseservice.addAllCourse(courses);
	}

	@GetMapping(value = "show")
	public Page<Course> show(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "3")int size) {
		Pageable paging = PageRequest.of(page, size);
		return courseservice.findAll(paging);
	}

	@GetMapping("specificcourse/{courseName}")
	public ResponseEntity<Course> findByCourseName(@PathVariable("courseName") String courseName) {
		Optional<Course> courseDataById = courseservice.findByCourseName(courseName);
		
		if (courseDataById.isPresent()) {
			return new ResponseEntity<>(courseDataById.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}


	@PutMapping("Update/{courseId}")
	public ResponseEntity<Course> updateCourse(@PathVariable("courseId") ObjectId courseId, @RequestBody Course course){


		if(courseservice.updateByCourse(courseId,course)!=null)
			return new ResponseEntity<>(courseservice.updateByCourse(courseId,course),HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		
	@DeleteMapping("/deletecourse/{courseName}")
	public ResponseEntity<Course> deleteByCourseName(@PathVariable("courseName") String courseName) {
		try {
			courseservice.deleteByCourseName(courseName);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}