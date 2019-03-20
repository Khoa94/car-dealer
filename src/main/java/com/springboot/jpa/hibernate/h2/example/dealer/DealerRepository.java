package com.springboot.jpa.hibernate.h2.example.dealer;

import com.springboot.jpa.hibernate.h2.example.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer> {

//    @Query("SELECT s FROM Student s WHERE name=:name")
//    public List<Student> findStudentByName(@Param("name") String name);

//    @Query("Insert into dealer_car(dealer_id, car_id) values (:dealer_id, :car_id)")
//    public int insert(@Param("dealer_id") String );
}
