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
public class JobDTO {

    public String jobId;
    public CompanyDTO company;
    public String jobReq;
    public String vacancies;
    public float salary;
    public String jobInf;

    public JobDTO() {
    }

    public JobDTO(String jobId, CompanyDTO company, String jobReq, String vacancies, float salary, String jobInf) {
        this.jobId = jobId;
        this.company = company;
        this.jobReq = jobReq;
        this.vacancies = vacancies;
        this.salary = salary;
        this.jobInf = jobInf;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public String getJobReq() {
        return jobReq;
    }

    public void setJobReq(String jobReq) {
        this.jobReq = jobReq;
    }

    public String getVacancies() {
        return vacancies;
    }

    public void setVacancies(String vacancies) {
        this.vacancies = vacancies;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getJobInf() {
        return jobInf;
    }

    public void setJobInf(String jobInf) {
        this.jobInf = jobInf;
    }
    
}
