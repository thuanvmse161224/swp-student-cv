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
    public String StudentId;
    public String JobPosition;
    public String EduQua;
    public String Experience;
    public String StuName;
    public int PhoneNum;
    public String Addr;
    public String Email;
    
    public Student(){
        
    }

    public Student(String StudentId, String JobPosition, String EduQua, String Experience, String StuName, int PhoneNum, String Addr, String Email) {
        this.StudentId = StudentId;
        this.JobPosition = JobPosition;
        this.EduQua = EduQua;
        this.Experience = Experience;
        this.StuName = StuName;
        this.PhoneNum = PhoneNum;
        this.Addr = Addr;
        this.Email = Email;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getJobPosition() {
        return JobPosition;
    }

    public void setJobPosition(String JobPosition) {
        this.JobPosition = JobPosition;
    }

    public String getEduQua() {
        return EduQua;
    }

    public void setEduQua(String EduQua) {
        this.EduQua = EduQua;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String StuName) {
        this.StuName = StuName;
    }

    public int getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(int PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String Addr) {
        this.Addr = Addr;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Student{" + "StudentId=" + StudentId + ", JobPosition=" + JobPosition + ", EduQua=" + EduQua + ", Experience=" + Experience + ", StuName=" + StuName + ", PhoneNum=" + PhoneNum + ", Addr=" + Addr + ", Email=" + Email + '}';
    }
    
    
        
}
