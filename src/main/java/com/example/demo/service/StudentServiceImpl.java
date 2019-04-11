package com.example.demo.service;

import com.example.demo.enums.MessageTags;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.RegisterRequest;
import com.example.demo.request.UpdateRequest;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public Response registerStudent(RegisterRequest registerRequest) {
        Student student= new Student();
        student.setFirstName(registerRequest.getFirstName());
        student.setLastName(registerRequest.getLastName());
        student.setAddress(registerRequest.getAddress());
        student.setAge(registerRequest.getAge());
        student.setGuardian(registerRequest.getGuardian());


        studentRepository.save(student);

        return new Response(true, MessageTags.REGISTER_SUCCESS.name(),MessageTags.REGISTER_SUCCESS.getString());


    }

    @Override
    public Response updateStudent(UpdateRequest updateRequest) {
        Student existingStudent= studentRepository.findById(updateRequest.getId());
        existingStudent.setFirstName(updateRequest.getFirstName());
        existingStudent.setLastName(updateRequest.getLastName());
        existingStudent.setGuardian(updateRequest.getGuardian());
        existingStudent.setAddress(updateRequest.getAddress());
        existingStudent.setAge(updateRequest.getAge());

        studentRepository.save(existingStudent);

        return new Response(true, MessageTags.UPDATE_SUCCESS.name(),MessageTags.UPDATE_SUCCESS.getString());


    }

    @Override
    public List<Student> findAll() {
        List<Student> students= studentRepository.findAll();
        return  students;
    }

    @Override
    public Student fetch( int id) {
        Student student= studentRepository.findById(id);
        return student;
    }

    @Override
    public Response delete(int id) {
        Student student= studentRepository.findById(id);
        studentRepository.delete(student);
        return new Response(true,MessageTags.DELETE_SUCCESS.name(),MessageTags.DELETE_SUCCESS.getString());

    }
}
