package com.cdl.spring_boot_test2.modules.test.service.impl;

import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;
import com.cdl.spring_boot_test2.modules.test.entity.Student;
import com.cdl.spring_boot_test2.modules.test.repository.StudentRepository;
import com.cdl.spring_boot_test2.modules.test.service.StudentSevice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentSeviceImpl implements StudentSevice {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    @Transactional
    public Result<Student> insertStudent(Student student) {
        student.setCreateDate(LocalDateTime.now());
        studentRepository.saveAndFlush(student);
        return new Result<Student>(Result.ResultStatus.SUCCESS.status,
                "Insert success",student);
    }

    @Override
    public Student getStudentByStudentId(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Page<Student> getStudentsBySearchVo(SearchVo searchVo) {
        Sort.Direction direction = "desc".equalsIgnoreCase(searchVo.getSort()) ?
                Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = new Sort(direction,
                StringUtils.isBlank(searchVo.getOrderBy())?
                "studentId" : searchVo.getOrderBy());
        //起始页从零开始，前端传过来要减一
        Pageable pageable = PageRequest.of(
                searchVo.getCurrentPage()-1,searchVo.getPageSize(),sort);
        Student student = new Student();
        student.setStudentName(searchVo.getKeyWord());
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("studentName",math -> math.contains())
                .withIgnorePaths("studentId");
        Example<Student> example = Example.of(student,matcher);

        return studentRepository.findAll(example,pageable);


    }

    @Override
    public List<Student> getStudentsByStudentName(String studentName, int cardId) {

        if (cardId > 0) {
            return studentRepository.getStudentsByParams(studentName, cardId);
        } else {
//        return Optional
//                .ofNullable(studentRepository.findByStudentName(studentName))
//                .orElse(Collections.emptyList());
//        return Optional
//                .ofNullable(studentRepository.findByStudentNameLike(
//                        String.format("%s%S%s", "%", studentName, "%")))
//                .orElse(Collections.emptyList());
            return Optional
                    .ofNullable(studentRepository.findTop2ByStudentNameLike(
                            String.format("%s%S%s", "%", studentName, "%")))
                    .orElse(Collections.emptyList());
        }
    }
}
