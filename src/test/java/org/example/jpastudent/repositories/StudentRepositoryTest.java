package org.example.jpastudent.repositories;

import org.example.jpastudent.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testOneKevin(){
        List<Student> list = studentRepository.findAllByName("Kevin");
        assertEquals(1,list.size());
    }

    @Test
    void testOneViggo (){
        Student viggo = new Student();
        viggo.setName("Viggo");
        viggo.setBornDate(LocalDate.of(2004,4,10));
        studentRepository.save(viggo);
        List<Student> list = studentRepository.findAllByName("Viggo");
        assertEquals(1,list.size());
    }

}