package com.bernasko.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }

    public void addNewService(Student student) {
        Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());

        // Check if Email is present
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        //Save student if email doesn't already exist in db
        studentRepository.save(student);

        System.out.println(student);
    }

    public void deleteStudent(Long id) {
        //Check if student exist
       boolean exist =  studentRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("Student does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with this id does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
