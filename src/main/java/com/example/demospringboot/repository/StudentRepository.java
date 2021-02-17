package com.example.demospringboot.repository;
import com.example.demospringboot.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student save(Student student);
    List<Student> findAll();
}
