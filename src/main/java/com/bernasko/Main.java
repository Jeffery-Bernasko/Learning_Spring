package com.bernasko;

import com.bernasko.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World");
        SpringApplication.run(Main.class, args);
    }

//    public GreetResponse greet(){
//         GreetResponse response = new GreetResponse(
//                "Hello",
//                List.of("C++","Dart","JavaScript"),
//                new Person("Jeffery",23,"peter@email.com"));
//         return response;
//    }
//
//    record Person(String name,int age,String email){}
//
//    record GreetResponse(
//            String greet,
//            List<String> favProgramLang,
//            Person person
//                         ){}
}
