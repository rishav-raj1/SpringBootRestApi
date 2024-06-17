package com.restApiSpringBoot.restApiSpringBoot.services;

import com.restApiSpringBoot.restApiSpringBoot.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServicesImpl implements CourseService {

    List<Course> list;

    public CourseServicesImpl(){
     list = new ArrayList<>();
     list.add(new Course(145, "Java Course", "this course for Java"));
     list.add(new Course(123, "Spring Boot Course", "this course for Spring Boot"));

    }

    @Override
    public List<Course> getCourses(){
        return list;
    }

    @Override
    public Course getCourse(long courseId){

        Course c=null;
        for(Course course:list)
        {
            if(course.getId()==courseId)
            {
                c=course;
                break;
            }

        }

        return c;
    }

    @Override
    public Course addCourse(Course course){
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course){
        list.forEach(e ->{
            if (e.getId() == course.getId()) {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(long parseLong){
        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    }


}
