package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    // List<Course> list;
    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl() {
        //    list = new ArrayList<>();
        //    list.add(new Course(12, "Java", "This is a Java Course"));
        //    list.add(new Course(14, "React", "This is a React Course"));
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {


     /*   Course c = null;
        for (Course course : list)
            if (course.getId() == courseId) {
                c = course;
                break;
            }   */
        return courseDao.getById(courseId);
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
    public String deleteCourse(long courseId) {
      /*  for (Course c : list)
            if (c.getId() == courseId) {
                list.remove(c);
            }*/
        courseDao.delete(courseDao.getById(courseId));

        return "Course Deleted";
    }
}
