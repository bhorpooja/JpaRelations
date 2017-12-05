package com.codekul.JpaRelations.repo;

import com.codekul.JpaRelations.model.Dept;
import com.codekul.JpaRelations.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by pooja on 30/11/17.
 */
public interface DeptRepo extends JpaRepository<Dept,Integer> {

  Dept findByDeptName(String name);

}
