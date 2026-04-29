package com.exampletesta.demo.application.dto;

import lombok.Data;

@Data
public class StudentSaveDto {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String grade;
}