package com.example.schoolms.Services;

import com.example.schoolms.Exceptions.ApiResponse;
import com.example.schoolms.Models.Teacher;
import com.example.schoolms.Repositries.TeacherRepositry;
import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.past.AbstractPastInstantBasedValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final Teacher teacher;
    private final TeacherRepositry teacherRepositry;

    public List<Teacher> getTeachers(){
        return teacherRepositry.findAll();
    }
    public void addTeacher(Teacher t){
        teacherRepositry.save(t);
    }
    public void updateTeacher(Long id, Teacher t){
        Teacher oldTeacher = teacherRepositry.getById(id);
        if(oldTeacher == null){
            throw new ApiResponse("Teacher not found");
        }
        oldTeacher.setAge(t.getAge());
        oldTeacher.setEmail(t.getEmail());
        oldTeacher.setName(t.getName());
        teacherRepositry.save(oldTeacher);
    }

    public void deleteTeacher(Long id){
        Teacher oldTeacher = teacherRepositry.getById(id);
        if(oldTeacher == null){
            throw new ApiResponse("Teacher not found");
        }
        teacherRepositry.delete(oldTeacher);
    }

}
