package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.request.RegisterRequest;
import com.example.demo.request.UpdateRequest;
import com.example.demo.response.Response;

import java.util.List;

public interface StudentService {

    Response registerStudent (RegisterRequest registerRequest);
    Response updateStudent (UpdateRequest updateRequest);
    List<Student> findAll();
    Student fetch(int id);
    Response delete (int id);

}
