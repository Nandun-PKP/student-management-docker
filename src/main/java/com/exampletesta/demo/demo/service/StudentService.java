package com.exampletesta.demo.demo.service;

import com.exampletesta.demo.application.dto.StudentGenaralDto;
import com.exampletesta.demo.demo.entity.Student;
import com.exampletesta.demo.external.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.exampletesta.demo.application.dto.StudentSaveDto;

import java.util.Optional;


@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public ResponseEntity<StudentGenaralDto> getStudent(Integer id){
        StudentGenaralDto studentGenaralDto = new StudentGenaralDto();
        Optional<Student>  optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            studentGenaralDto.setId(student.getId());
            studentGenaralDto.setName(student.getName());
            return ResponseEntity.ok(studentGenaralDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> saveStudent(StudentSaveDto saveDto) {
        // 1. Database එකට දාන්න Entity object එකක් හදනවා
        Student student = new Student();

        // 2. DTO එකේ තියෙන දත්ත ටික Entity එකට මාරු කිරීම (Mapping)
        student.setId(saveDto.getId());
        student.setName(saveDto.getName());
        student.setAddress(saveDto.getAddress());
        student.setEmail(saveDto.getEmail());
        student.setGrade(saveDto.getGrade());

        // 3. Repository එක හරහා Database එකේ Save කිරීම
        studentRepository.save(student);

        return ResponseEntity.ok("Student saved successfully with all details!");
    }
    public String deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully!";
    }
    public String updateStudent(StudentSaveDto updateDto) {
        // 1. මේ ID එකෙන් කෙනෙක් ඉන්නවද බලනවා
        if (studentRepository.existsById(updateDto.getId())) {
            Student student = new Student();
            student.setId(updateDto.getId());
            student.setName(updateDto.getName());
            student.setAddress(updateDto.getAddress());
            student.setEmail(updateDto.getEmail());
            student.setGrade(updateDto.getGrade());

            studentRepository.save(student); // ID එක තියෙන නිසා මෙයා අලුත් පේළියක් හදන්නේ නැතුව තියෙන එක update කරනවා
            return "Student updated successfully!";
        }
        return "Student not found!";
    }
}
