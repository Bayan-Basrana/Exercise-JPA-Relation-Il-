package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiResponse.ApiException;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
private  final TeacherRepository teacherRepository;
    public List<Course> get (){
        return courseRepository.findAll();
    }

    public void  addCourse (Course course){
        courseRepository.save(course);
    }


    public void update (Integer id ,Course course){
        Course old = courseRepository.findCourseById(id);
        if (old==null){
            throw new ApiException("id not found");
        }
        old.setName(course.getName());
        courseRepository.save(old);
    }


    public void delete (Integer id ){
        Course course = courseRepository.findCourseById(id);
        if (course==null){
            throw new ApiException("id not found");
        }
        courseRepository.delete(course);
    }

    public String  getTeacher (Integer course_id){
        Course course =courseRepository.findCourseById(course_id);
        if (course==null){
            throw new ApiException("id not found");
        }

        return  course.getTeacher().getName();
    }
}
