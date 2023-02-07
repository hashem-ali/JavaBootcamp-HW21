package com.example.schoolms.Controllers;

import com.example.schoolms.Models.Teacher;
import com.example.schoolms.Services.TeacherService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher/")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final Teacher teacher;

    @GetMapping("getTeacher")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("addTeacher")
    public ResponseEntity addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher added");
    }

    @PostMapping("update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("deleted");
    }

}
