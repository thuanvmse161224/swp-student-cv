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
public class Job {
    public int JodId;
    public int CompanyId;
    public String JobReq;
    public String Vacancies;
    public int salary;
    public String JobInf;
    
    public Job(){
        
    }

    public Job(int JodId, int CompanyId, String JobReq, String Vacancies, int salary, String JobInf) {
        this.JodId = JodId;
        this.CompanyId = CompanyId;
        this.JobReq = JobReq;
        this.Vacancies = Vacancies;
        this.salary = salary;
        this.JobInf = JobInf;
    }

    public int getJodId() {
        return JodId;
    }

    public void setJodId(int JodId) {
        this.JodId = JodId;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int CompanyId) {
        this.CompanyId = CompanyId;
    }

    public String getJobReq() {
        return JobReq;
    }

    public void setJobReq(String JobReq) {
        this.JobReq = JobReq;
    }

    public String getVacancies() {
        return Vacancies;
    }

    public void setVacancies(String Vacancies) {
        this.Vacancies = Vacancies;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobInf() {
        return JobInf;
    }

    public void setJobInf(String JobInf) {
        this.JobInf = JobInf;
    }

    @Override
    public String toString() {
        return "Job{" + "JodId=" + JodId + ", CompanyId=" + CompanyId + ", JobReq=" + JobReq + ", Vacancies=" + Vacancies + ", salary=" + salary + ", JobInf=" + JobInf + '}';
    }
    
    
}
