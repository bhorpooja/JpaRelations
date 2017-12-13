package com.codekul.JpaRelations.model;

import javax.persistence.*;

/**
 * Created by pooja on 30/11/17.
 */
@Entity
public class Student {

    @Id
    Integer id;
    String name;
    String city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="deptid")
    Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
