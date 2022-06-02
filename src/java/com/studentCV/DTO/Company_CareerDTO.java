/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DTO;

/**
 *
 * @author tungp
 */
public class Company_CareerDTO {
    public CareerDTO career;
    public CompanyDTO company;

    public Company_CareerDTO() {
    }

    public Company_CareerDTO(CareerDTO career, CompanyDTO company) {
        this.career = career;
        this.company = company;
    }

    public CareerDTO getCareer() {
        return career;
    }

    public void setCareer(CareerDTO career) {
        this.career = career;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
    
}
