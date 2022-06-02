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
public class Company {
    public String companyId;
    public String Specialization;
    public String Email;
    public String PhoneNumber;
    public String Addr;
    
    public Company(){
      }

    public Company(String companyId, String Specialization, String Email, String PhoneNumber, String Addr) {
        this.companyId = companyId;
        this.Specialization = Specialization;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Addr = Addr;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String Addr) {
        this.Addr = Addr;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", Specialization=" + Specialization + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", Addr=" + Addr + '}';
    }
    
    
}
