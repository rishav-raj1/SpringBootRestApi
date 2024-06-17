package com.restApiSpringBoot.restApiSpringBoot.controller;

import com.restApiSpringBoot.restApiSpringBoot.entities.Course;
import com.restApiSpringBoot.restApiSpringBoot.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

//    @GetMapping("/home")
//    public String home() {
//        return "this is home page";
//    }

    //get the courses
// for mvc  -  @RequestMapping(path="/courses",method = RequestMethod.GET)

    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.courseService.getCourses();
    }

    //single courses get
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //courses add
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    //update course using PUT request
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    //delete the course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
