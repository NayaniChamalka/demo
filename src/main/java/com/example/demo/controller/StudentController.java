package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.request.RegisterRequest;
import com.example.demo.request.UpdateRequest;
import com.example.demo.response.Response;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST, path = "/user")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(path = "/register")
    public Response registerStudent(@RequestBody RegisterRequest registerRequest) {
        Response registerResponse = studentService.registerStudent(registerRequest);
        return registerResponse;
    }

    @PostMapping(path = "/update")
    public Response updateStudent(@RequestBody UpdateRequest updateRequest) {
        Response updateResponse = studentService.updateStudent(updateRequest);
        return updateResponse;
    }

    @GetMapping(path="/all")
        public List<Student> findAll (){
        List<Student> students=  studentService.findAll();
        return  students;

    }

    @GetMapping(path="/fetch")
    public Student fetch (@RequestParam int id){
        Student student=  studentService.fetch( id);
        return  student;

    }

    @DeleteMapping (path="/delete")
    public Response delete (@RequestParam int id){
        Response response =  studentService.delete(id);
        return  response;

    }



}
