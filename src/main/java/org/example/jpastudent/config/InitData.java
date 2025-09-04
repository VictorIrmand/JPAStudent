package org.example.jpastudent.config;

import org.example.jpastudent.model.Student;
import org.example.jpastudent.model.Unicode;
import org.example.jpastudent.repositories.StudentRepository;
import org.example.jpastudent.repositories.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UnicodeRepository unicodeRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Kevin");
        s1.setBornDate(LocalDate.of(2003,6,16));
        s1.setBornTime(LocalTime.of(8,52,2));

        studentRepository.save(s1);

        Set<Character> letters = new HashSet<>();

        for (char c = 'a'; c <= 'z';c++){
            letters.add(c);
        }
        for (char c = 'A'; c <= 'Z';c++){
            letters.add(c);
        }
        for (Character c : letters){
            if (!unicodeRepository.existsById((int)c)){
            Unicode unicode = new Unicode();
            unicode.setBogstav(c);
            unicode.setUnicode((int)c);
            unicodeRepository.save(unicode);
        }
        }


    }
}
