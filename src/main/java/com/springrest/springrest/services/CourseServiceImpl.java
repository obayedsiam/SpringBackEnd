package com.springrest.springrest.services;

import com.springrest.springrest.repository.CourseRepository;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public List<Course> getCourses() {
        return repository.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        return repository.findById(courseId).get();
    }

    @Override
    public Course addCourse(Course course) {
        repository.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        repository.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
       // String ret = "Course Deleted";
        repository.delete(repository.getById(courseId));
   //    return ret;
    }
}
