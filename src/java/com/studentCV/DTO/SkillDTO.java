/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DTO;

/**
 *
 * @author tungp
 */
public class SkillDTO {

    public String skillId;
    public String skillName;
    public String skillType;

    public SkillDTO() {
    }

    public SkillDTO(String skillId, String skillName, String skillType) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillType = skillType;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

}
