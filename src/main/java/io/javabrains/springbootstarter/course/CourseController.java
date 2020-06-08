package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController
{
    @Autowired
    private CourseService courseService;

    //GETALL
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllTopics(@PathVariable String id)
    {
        return courseService.getAllCourses(id);
    }

    //GET
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id)
    {
        return courseService.getCourse(id);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id)
    {
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public  void deleteCourse (@PathVariable String id)
    {
        courseService.deleteCourse(id);
    }
}
