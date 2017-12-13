package com.codekul.JpaRelations.repo;

import com.codekul.JpaRelations.model.Dept;
import com.codekul.JpaRelations.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by pooja on 30/11/17.
 */

public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query("select id,name,city from Student where deptid=:id")
    List<Student> findByDept(@Param("id") Integer deptid);
}
