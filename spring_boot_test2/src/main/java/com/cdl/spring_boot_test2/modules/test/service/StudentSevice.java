package com.cdl.spring_boot_test2.modules.test.service;

import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;
import com.cdl.spring_boot_test2.modules.test.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentSevice {
    Result<Student> insertStudent(Student student);

    Student getStudentByStudentId(int studentId);

    Page<Student> getStudentsBySearchVo(SearchVo searchVo);


    List<Student> getStudentsByStudentName(String studentName, int cardId);


}
