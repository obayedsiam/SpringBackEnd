package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        return courseDao.findById(courseId).get();
    }

    @Override
    public Course addCourse(Course course) {
        //   list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

      /*  for (Course c : list)
            if(c.getId()== course.getId()){
               c.setTitle(course.getTitle()) ;
               c.setDescription(course.getDescription());
        }*/
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        courseDao.delete(courseDao.getById(courseId));
    }
}
