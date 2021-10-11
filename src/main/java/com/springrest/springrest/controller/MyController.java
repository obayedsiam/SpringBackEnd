package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService service;

    // Get List of courses
    @CrossOrigin
    @GetMapping("/course")
    public List<Course> getCourse() {
        return this.service.getCourses();
    }

    // Get Course with Id
    @CrossOrigin
    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.service.getCourse(Long.parseLong(courseId));
    }

    // Add Course
    @CrossOrigin
    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course) {
        return this.service.addCourse(course);
    }

    //Update course with Id
    @CrossOrigin
    @PutMapping("course/{courseId}")
    public Course updateCourse(@RequestBody Course course) {
        return this.service.updateCourse(course);
    }

    @CrossOrigin
    @DeleteMapping("course/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.service.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
