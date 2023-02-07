package com.example.schoolms.Repositries;

import com.example.schoolms.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositry extends JpaRepository<Teacher, Long> {
}
