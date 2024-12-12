package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.ApiResponse.ApiResponse;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private  final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity get (){
        return ResponseEntity.status(200).body(courseService.get());
    }


    @PostMapping("/add")
    public ResponseEntity add (@RequestBody @Valid Course course ){
        courseService.addCourse(course);
        ;        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update (@PathVariable Integer id , @RequestBody @Valid Course course ){
        courseService.update(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete (@PathVariable Integer id){
        courseService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
    }

    @GetMapping("/getTeacher/{course_id}")
    public ResponseEntity getTeacher (@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(courseService.getTeacher(course_id));
    }
}
