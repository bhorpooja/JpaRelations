package com.codekul.JpaRelations.controller;

import com.codekul.JpaRelations.model.Dept;
import com.codekul.JpaRelations.model.Student;
import com.codekul.JpaRelations.repo.DeptRepo;
import com.codekul.JpaRelations.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by pooja on 30/11/17.
 */
@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    DeptRepo deptRepo;


    @PostMapping(value = "/insertStudent")
    public String insertStudent(@RequestBody Student student){

        Integer dId=student.getDept().getId();
        Dept dept=deptRepo.findOne(dId);

        if(dept==null) {
            Dept dObj = deptRepo.findByDeptName(student.getDept().getDeptName());
            if (dObj != null) {
                Integer d_id =dObj.getId();
               student.getDept().setId(d_id);
                studentRepo.save(student);
                return "Data inserted to Student only";
            } else {
//                deptRepo.save(student.getDept());
               studentRepo.save(student);
               return "Data inserted to Dept and Student";
            }
        }
        else {
            String dName=student.getDept().getDeptName();
            if(dName.equalsIgnoreCase(dept.getDeptName())) {
                studentRepo.save(student);
                return "Data inserted to Student";
            }
            else {
                return "wrong data";
            }
            }
    }

    @GetMapping("/getStudent/{deptid}")
    public List<Student> getStudent(@PathVariable Integer deptid){
        List<Student> stud=studentRepo.findByDept(deptid);
//        List<Student> stud=studentRepo.findByDept(deptRepo.findById(id));
        return stud;
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteRecord(@PathVariable Integer id){
        studentRepo.delete(id);
        return "Record Deleted";
    }
}
