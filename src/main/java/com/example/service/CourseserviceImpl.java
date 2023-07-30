package com.example.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Course;
import com.example.respository.Courserepository;

@Service
public class CourseserviceImpl {

	@Autowired
	private Courserepository courserepository;

	public Page<Course> findAll(Pageable pageable) {
		return courserepository.findAll(pageable);
	}

	public Course addCourse(Course course) {
		return courserepository.save(course);
	}

	public Optional<Course> findByCourseName(String courseName) {
		return courserepository.findByCourseName(courseName);
	}

	public void deleteByCourseName(String courseName) {
		// TODO Auto-generated method stub
		courserepository.deleteByCourseName(courseName);
	}
	
	public Optional<Course> findByCourseId(ObjectId courseId){
		return courserepository.findByCourseId(courseId);
	}
	
	public Course updateByCourse(ObjectId courseId,Course course){
		Optional<Course> courseData = courserepository.findByCourseId(courseId);
		
		if(courseData.isPresent()) {
			Course _course = courseData.get();
			_course.setCourseName(course.getCourseName());
			_course.setAuthorId(course.getAuthorId());
			_course.setCourseSubtitle(course.getCourseSubtitle());
			return courserepository.save(_course);
		}else {
			return null;
		}
	}

	public List<Course> addAllCourse(List<Course> courses) {
		return courserepository.saveAll(courses);
    }
}
