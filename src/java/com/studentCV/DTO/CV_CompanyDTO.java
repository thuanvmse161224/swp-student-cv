/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DTO;

/**
 *
 * @author tungp
 */
public class CV_CompanyDTO {
    public CV_DTO cv;
    public CompanyDTO company;

    public CV_CompanyDTO() {
    }

    public CV_CompanyDTO(CV_DTO cv, CompanyDTO company) {
        this.cv = cv;
        this.company = company;
    }

    public CV_DTO getCv() {
        return cv;
    }

    public void setCv(CV_DTO cv) {
        this.cv = cv;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    
}
