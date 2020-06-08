package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService
{
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId)
    {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id)
    {
       return courseRepository.findById(id);
    }

    public void addCourse(Course course)
    {
        courseRepository.save(course);
    }

    public void updateCourse(Course course)
    {
        //when there is no "topic" it will save. when there is one, it's going to be updated (like rewritten(auto updated))
        courseRepository.save(course);
    }

    public void deleteCourse(String id)
    {
        courseRepository.deleteById(id);
    }
}

