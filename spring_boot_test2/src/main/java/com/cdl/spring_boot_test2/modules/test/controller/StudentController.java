package com.cdl.spring_boot_test2.modules.test.controller;

import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.test.entity.Student;
import com.cdl.spring_boot_test2.modules.test.service.StudentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentSevice studentSevice;


    /**
     *127.0.0.1/api/student --- post
     * {"studentName":"chengduolang1","studentCard":{"cardId":"1"}}
     */
    @PostMapping(value = "student",consumes = "application/json")
    public Result<Student> insertStudent(@RequestBody Student student){
        return studentSevice.insertStudent(student);
    }
}
