/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.JobDTO;
import com.studentCV.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Asus
 */
public class JobDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public JobDAO() {

    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public ArrayList<JobDTO> getAllJob() throws Exception {

        String sql = "Select JobId,\n"
                + "	CompanyId,\n"
                + "	JobReq,\n"
                + "	JobName,\n"
                + "	Salary,\n"
                + "	JobType\n"
                + "	JobLocation\n"
                + "	JobExperince\n"
                + "	JobPostDate\n"
                + "	JobDescription\n"
                + "     Status\n"
                + "From Job\n";
        ArrayList<JobDTO> lst = new ArrayList<>();
        try {
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            rs = pstm.executeQuery();
            if (rs.next()) {
                int jid = rs.getInt("JobId");
                String cid = rs.getString("CompanyId");
                String jreq = rs.getString("JobReq");
                String jname = rs.getString("JobName");
                Float salary = rs.getFloat("Salary");
                String jtype = rs.getString("JobType");
                String jloc = rs.getString("JobLocation");
                String jexp = rs.getString("JobExperince");
                LocalDate jpdate = LocalDate.parse(rs.getString("JobPostDate"));
                String jdes = rs.getString("JobDescription");
                Boolean status = rs.getBoolean("Status");

                CompanyDAO c = new CompanyDAO();

                JobDTO job = new JobDTO(jid, c.getCompanybyId(cid), jname, jreq, salary, jtype, jloc, jexp, jpdate, jdes, status);
                lst.add(job);
            }
        } finally {
            closeConnection();
        }
        return lst;
    }

    public JobDTO getJobById(int id) throws NamingException, SQLException, Exception {
        JobDTO result = null;
        String sql = "Select CompanyId,\n"
                + "	JobReq,\n"
                + "	JobName,\n"
                + "	Salary,\n"
                + "	JobType\n"
                + "	JobLocation\n"
                + "	JobExperince\n"
                + "	JobPostDate\n"
                + "	JobDescription\n"
                + "     Status\n"
                + "From Job\n"
                + "Where JobId =?";

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                pstm.setInt(1, id);
                while (rs.next()) {
                    String cid = rs.getString("CompanyId");
                    String jname = rs.getString("JobName");
                    String jreq = rs.getString("JobReq");
                    float salary = rs.getFloat("Salary");
                    String jtype = rs.getString("JobType");
                    String jloca = rs.getString("JobLocation");
                    String jexp = rs.getString("JobExperince");
                    LocalDate jpdate = LocalDate.parse(rs.getString("JobPostDate"));
                    String jdes = rs.getString("JobDescription");
                    Boolean status = rs.getBoolean("Status");
                    CompanyDAO c = new CompanyDAO();
                    result = new JobDTO(id, c.getCompanybyId(cid), jname, jreq, salary, jtype, jloca, jexp, jpdate, jdes, status);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(JobDTO job) throws SQLException, Exception {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Job]"
                    + "      ,([JobId]\n"
                    + "      ,([CompanyId]\n"
                    + "      ,([JobName]\n"
                    + "      ,([JobReq]\n"
                    + "      ,([Salary]\n"
                    + "      ,([JobType]\n"
                    + "      ,([JobLocation]\n"
                    + "      ,[JobExperince])\n"
                    + "      ,[JobPostDate])\n"
                    + "      ,[JobDescription])\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?,?,?,?,?,?,?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, job.getJobId());
            pstm.setString(2, job.getCompany().getCompanyId());
            pstm.setString(3, job.getJobName());
            pstm.setString(4, job.getJobReq());
            pstm.setFloat(5, job.getSalary());
            pstm.setString(6, job.getJobType());
            pstm.setString(7, job.getJobLocation());
            pstm.setString(8, job.getJobExperience());
            pstm.setDate(9, java.sql.Date.valueOf(job.getJobPostDate()));
            pstm.setString(10, job.getJobDescription());
            pstm.setBoolean(11, job.isStatus());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(JobDTO job) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE [StudentCV].[dbo].[Job] SET"
                    + "      ,[Status]=?\n"
                    + " WHERE JobId=?";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setBoolean(1, job.isStatus());
            pstm.setInt(2, job.getJobId());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(JobDTO job) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Job] SET"
                + "      ,([JobId]\n"
                + "      ,([CompanyId]\n"
                + "      ,([JobName]\n"
                + "      ,([JobReq]\n"
                + "      ,([Salary]\n"
                + "      ,([JobType]\n"
                + "      ,([JobLocation]\n"
                + "      ,[JobExperince])\n"
                + "      ,[JobPostDate])\n"
                + "      ,[JobDescription])\n"
                + "      ,[Status])\n"
                + "Values(?,?,?,?,?,?,?,?,?,?,?)"
                + " WHERE JobId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, job.getJobId());
                pstm.setString(2, job.getCompany().getCompanyId());
                pstm.setString(3, job.getJobName());
                pstm.setString(4, job.getJobReq());
                pstm.setFloat(5, job.getSalary());
                pstm.setString(6, job.getJobType());
                pstm.setString(7, job.getJobLocation());
                pstm.setString(8, job.getJobExperience());
                pstm.setDate(9, java.sql.Date.valueOf(job.getJobPostDate()));
                pstm.setString(10, job.getJobDescription());
                pstm.setBoolean(11, job.isStatus());

                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

}
