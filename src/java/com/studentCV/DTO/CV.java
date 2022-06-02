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
public class CV {
    public int CvId;
    public int StudentId;
    
    public CV(){
        
}

    public CV(int CvId, int StudentId) {
        this.CvId = CvId;
        this.StudentId = StudentId;
    }

    public int getCvId() {
        return CvId;
    }

    public void setCvId(int CvId) {
        this.CvId = CvId;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    @Override
    public String toString() {
        return "CV{" + "CvId=" + CvId + ", StudentId=" + StudentId + '}';
    }
     
    
    
}

