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
                + "	Vacancies,\n"
                + "	Salary,\n"
                + "	JobInf\n"
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
                String vac = rs.getString("Vacancies");
                Float salary = rs.getFloat("Salary");
                String jinf = rs.getString("JobInf");
                Boolean status = rs.getBoolean("Status");

                CompanyDAO c = new CompanyDAO();

                JobDTO job = new JobDTO(jid, c.getCompanybyId(cid), jreq, vac, salary, jinf, status);
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
                + "	Vacancies,\n"
                + "	Salary,\n"
                + "	JobInf\n"
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
                    String jreq = rs.getString("JobReq");
                    String vaca = rs.getString("Vacancies");
                    float salary = rs.getFloat("Salary");
                    String jinf = rs.getString("JobInf");
                    Boolean status = rs.getBoolean("Status");
                    CompanyDAO c = new CompanyDAO();
                    result = new JobDTO(id, c.getCompanybyId(cid), jreq, vaca, salary, jinf, status);

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
                    + "      ,([JobReq]\n"
                    + "      ,([Vacancies]\n"
                    + "      ,([Salary]\n"
                    + "      ,[JobInf])\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?,?,?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, job.getJobId());
            pstm.setString(2, job.getCompany().getCompanyId());
            pstm.setString(3, job.getJobReq());
            pstm.setString(4, job.getVacancies());
            pstm.setFloat(5, job.getSalary());
            pstm.setString(6, job.getJobInf());
            pstm.setBoolean(7, job.isStatus());
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
                + "      ,[CompanyId]=?\n"
                + "      ,[JobReq]=?\n"
                + "      ,[Vacacines]=?\n"
                + "      ,[Salary]=?\n"
                + "      ,[JobInf]=?\n"
                + "      ,[Status]=?\n"
                + " WHERE JobId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setString(1, job.getCompany().getCompanyId());
                pstm.setString(2, job.getJobReq());
                pstm.setString(3, job.getVacancies());
                pstm.setFloat(4, job.getSalary());
                pstm.setString(5, job.getJobInf());
                pstm.setBoolean(6, job.isStatus());
                pstm.setInt(7, job.getJobId());

                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

}
