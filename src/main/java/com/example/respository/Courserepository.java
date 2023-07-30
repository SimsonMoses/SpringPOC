package com.example.respository;

import java.util.List;
import java.util.Optional;


import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Course;

public interface Courserepository extends MongoRepository<Course, ObjectId> {

//			Course findByCourseName(String courseName);
	Course findByAuthorId(String AuthorId);


//			List<Course> findAllByOrderByGpaDesc();
	Optional<Course> findByCourseName(String courseName);

	Optional<Course> deleteAllByCourseName(String courseName);

	Optional<Course> findByCourseId(ObjectId courseId);

	Course save(ObjectId objectId);

	void deleteByCourseName(String courseName);
	

}