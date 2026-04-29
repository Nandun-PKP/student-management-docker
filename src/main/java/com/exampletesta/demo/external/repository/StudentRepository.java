package com.exampletesta.demo.external.repository;

import com.exampletesta.demo.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer> {
}
