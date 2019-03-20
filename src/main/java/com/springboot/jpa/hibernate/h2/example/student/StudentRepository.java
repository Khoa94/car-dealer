package com.springboot.jpa.hibernate.h2.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query("SELECT s FROM Student s WHERE name=:name")
    public List<Student> findStudentByName(@Param("name") String name);
}
