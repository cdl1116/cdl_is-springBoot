package com.cdl.spring_boot_test2.modules.test.controller;

import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;
import com.cdl.spring_boot_test2.modules.test.entity.Student;
import com.cdl.spring_boot_test2.modules.test.service.StudentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     *127.0.0.1/api/student/1
     */
    @GetMapping("/student/{studentId}")
    public Student getStudentByStudentId(@PathVariable int studentId){
        return studentSevice.getStudentByStudentId(studentId);
    }

    /**
     * 127.0.0.1/api/students ---- post
     * {"currentPage":"1","pageSize":"5","keyWord":"z","orderBy":"studentName","sort":"desc"}
     */
    @PostMapping(value = "/students",consumes ="application/json" )
    public Page<Student> getStudentsBySearchVo(@RequestBody SearchVo searchVo){
        return studentSevice.getStudentsBySearchVo(searchVo);
    }

    /**
     * 127.0.0.1/api/students?studentName=cheng ---- get
     */
//    @GetMapping("/students")
//    public List<Student> getStudentsByStudentName(@RequestParam String studentName){
//        return studentSevice.getStudentsByStudentName(studentName);
//    }
    /**
     * 127.0.0.1/api/students1?studentName=cheng&cardId=1 ---- get
     */
    @GetMapping("/students1")
    public List<Student> getStudentsBiParams(@RequestParam String studentName,
                                             @RequestParam(required = false,defaultValue = "0") Integer cardId){
        return studentSevice.getStudentsByStudentName(studentName,cardId);
    }

}
