package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {
    @Autowired
    StudentService StudentService;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @PostMapping ("/Save-Student")
    public ResponseEntity<String> SaveStudent( @RequestBody @Valid Student student, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Data is not valid", HttpStatus.BAD_REQUEST);

        }else{
            StudentService.saveStudent(student);
            return new ResponseEntity<>("Student Saved!", HttpStatus.OK);
        }

    }


}
