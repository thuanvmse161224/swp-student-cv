/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DTO;

/**
 *
 * @author tungp
 */
public class Stu_JobDTO {

    public StudentDTO student;
    public JobDTO job;

    public Stu_JobDTO() {
    }

    public Stu_JobDTO(StudentDTO student, JobDTO job) {
        this.student = student;
        this.job = job;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public JobDTO getJob() {
        return job;
    }

    public void setJob(JobDTO job) {
        this.job = job;
    }

}
