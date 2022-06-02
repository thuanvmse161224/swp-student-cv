/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentCV.DTO;

/**
 *
 * @author minhh
 */
public class Student {

    public String studentId;
    public String jobPosition;
    public String eduQua;
    public String experience;
    public String stuName;
    public String phoneNum;
    public String addr;
    public String email;

    public Student() {
    }

    public Student(String studentId, String jobPosition, String eduQua, String experience, String stuName, String phoneNum, String addr, String email) {
        this.studentId = studentId;
        this.jobPosition = jobPosition;
        this.eduQua = eduQua;
        this.experience = experience;
        this.stuName = stuName;
        this.phoneNum = phoneNum;
        this.addr = addr;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getEduQua() {
        return eduQua;
    }

    public void setEduQua(String eduQua) {
        this.eduQua = eduQua;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
