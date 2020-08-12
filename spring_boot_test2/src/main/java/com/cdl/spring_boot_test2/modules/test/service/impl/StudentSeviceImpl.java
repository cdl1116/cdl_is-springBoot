package com.cdl.spring_boot_test2.modules.test.service.impl;

import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.test.entity.Student;
import com.cdl.spring_boot_test2.modules.test.repository.StudentRepository;
import com.cdl.spring_boot_test2.modules.test.service.StudentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentSeviceImpl implements StudentSevice {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Result<Student> insertStudent(Student student) {
        student.setCreateDate(LocalDateTime.now());
        studentRepository.saveAndFlush(student);
        return new Result<Student>(Result.ResultStatus.SUCCESS.status,
                "Insert success",student);
    }
}
