package com.exampletesta.demo.application.controllers;


import com.exampletesta.demo.application.dto.StudentGenaralDto;
import com.exampletesta.demo.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.exampletesta.demo.application.dto.StudentSaveDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<StudentGenaralDto> getStudent(@RequestParam Integer id){
       return studentService.getStudent(id);
    }
    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody StudentSaveDto studentSaveDto) {
        return studentService.saveStudent(studentSaveDto);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody StudentSaveDto updateDto) {
        return studentService.updateStudent(updateDto);
    }
}
