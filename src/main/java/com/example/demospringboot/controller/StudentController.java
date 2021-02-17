package com.example.demospringboot.controller;


import com.example.demospringboot.model.Student;
import com.example.demospringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository strepo;

   @GetMapping("/all")
    public Iterable<Student> getAllStudent(){ return strepo.findAll(); }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
       return strepo.save(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent (@PathVariable long id){
       Student updateStudent = null;
       Optional<Student> student = strepo.findById(id);
       if(student.isPresent()){
           updateStudent = student.get();
           updateStudent.setName(updateStudent.getName() + "_updated");
       }
    return strepo.save(updateStudent);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
       strepo.deleteById(id);
    }

}
