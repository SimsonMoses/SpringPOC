package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "course")
public class Course {

	@Id
	@Field("_id")
	@JsonIgnore
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private ObjectId courseId;
	private String courseName;
	private String courseSubtitle;
	private String authorId;


	public ObjectId getCourseId() {
		return courseId;
	}

	public void setCourseId(ObjectId courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseSubtitle() {
		return courseSubtitle;
	}

	public void setCourseSubtitle(String courseSubtitle) {
		this.courseSubtitle = courseSubtitle;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Course(ObjectId courseId, String courseName, String courseSubtitle, String authorId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseSubtitle = courseSubtitle;
		this.authorId = authorId;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "{ CourseId:\n\"" + courseId + "\",\n courseName:\n\"" + courseName + "\",\n courseSubtitle:\n\""
				+ courseSubtitle + "\",\n AuthorId:\n\"" + authorId + "}";
	}
}
