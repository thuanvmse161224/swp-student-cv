/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DTO;

/**
 *
 * @author tungp
 */
public class Stu_SkillDTO {

    public StudentDTO student;
    public SkillDTO skill;

    public Stu_SkillDTO() {
    }

    public Stu_SkillDTO(StudentDTO student, SkillDTO skill) {
        this.student = student;
        this.skill = skill;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public SkillDTO getSkill() {
        return skill;
    }

    public void setSkill(SkillDTO skill) {
        this.skill = skill;
    }

}
