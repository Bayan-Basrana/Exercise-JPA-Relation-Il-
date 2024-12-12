package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.ApiResponse.ApiResponse;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity get (){
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }


    @PostMapping("/add")
    public ResponseEntity add (@RequestBody @Valid Teacher teacher ){
        teacherService.addTeacher(teacher);
        ;        return ResponseEntity.status(200).body(new ApiResponse("added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update (@PathVariable Integer id , @RequestBody @Valid Teacher teacher ){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete (@PathVariable Integer id){
        teacherService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted successfully"));
    }

    @GetMapping("/getTeacherByTeacherId/{id}")
    public ResponseEntity getTeacherByTeacherId (@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherByTeacherId(id));
    }

    @PutMapping("/assign/{teacher_id}/{course_id}")
    public ResponseEntity assignTeacherToCourse (@PathVariable Integer teacher_id ,@PathVariable Integer course_id){
        teacherService.assignTeacherToCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("assign successfully"));
    }


}
