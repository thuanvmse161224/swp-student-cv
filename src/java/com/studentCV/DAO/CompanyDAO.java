/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.CompanyDTO;
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
public class CompanyDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    public CompanyDAO() {

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

    public ArrayList<CompanyDTO> getAllCompany() throws Exception {

        String sql = "Select CompanyId,\n"
                + "	Specialization,\n"
                + "	Email,\n"
                + "	PhoneNumber,\n"
                + "	Addr,\n"
                + "     Status\n"
                + "From Job\n";
        ArrayList<CompanyDTO> lst = new ArrayList<>();
        try {
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            rs = pstm.executeQuery();
            if (rs.next()) {
                String cid = rs.getString("CompanyId");
                String spec = rs.getString("Specialization");
                String email = rs.getString("Email");
                String phonenum = rs.getString("PhoneNumber");
                String address = rs.getString("Addr");
                Boolean status = rs.getBoolean("Status");
                CompanyDTO company = new CompanyDTO(cid, spec, email, phonenum, address, status);
                lst.add(company);
            }
        } finally {
            closeConnection();
        }
        return lst;
    }

    public CompanyDTO getCompanybyId(String id) throws NamingException, SQLException, Exception {
        CompanyDTO result = null;
        String sql = "Select Specialization,\n"
                + "	Email,\n"
                + "	PhoneNumber,\n"
                + "	Addr,\n"
                + "	Status\n"
                + "From Company\n"
                + "Where CompanyId =?";

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                pstm.setString(1, id);
                while (rs.next()) {
                    String cid = rs.getString("CompanyId");
                    String spec = rs.getString("Specialization");
                    String email = rs.getString("Email");
                    String phonenum = rs.getString("PhoneNumber");
                    String address = rs.getString("Addr");
                    Boolean status = rs.getBoolean("Status");
                    result = new CompanyDTO(cid, spec, email, phonenum, address, status);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(CompanyDTO company) throws SQLException, Exception {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Company]"
                    + "      ,([CompanyId]\n"
                    + "      ,([Specialization]\n"
                    + "      ,([Email]\n"
                    + "      ,([PhoneNumber]\n"
                    + "      ,[Addr])\n"
                    + "      ,[Status])\n"
                    + "Values(?,?,?,?,?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();

            pstm = con.prepareStatement(sql);
            pstm.setString(1, company.getCompanyId());
            pstm.setString(2, company.getSpecialization());
            pstm.setString(3, company.getEmail());
            pstm.setString(4, company.getPhoneNumber());
            pstm.setString(5, company.getAddr());
            pstm.setBoolean(6, company.isStatus());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(CompanyDTO c) throws Exception {
        boolean check = false;
        try {
            String sql = "UPDATE [StudentCV].[dbo].[Company] SET"
                    + "      ,[Status]=?\n"
                    + " WHERE CompanyId=?";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setBoolean(1, c.isStatus());
            pstm.setString(2, c.getCompanyId());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(CompanyDTO c) throws Exception {
        String sql = "UPDATE [StudentCV].[dbo].[Company] SET"
                + "      ,([Specialization]\n"
                + "      ,([Email]\n"
                + "      ,([PhoneNumber]\n"
                + "      ,[Addr])\n"
                + "      ,[Status])\n"
                + "Values(?,?,?,?,?)"
                + " WHERE CompanyId=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);

                pstm.setString(1, c.getSpecialization());
                pstm.setString(2, c.getEmail());
                pstm.setString(3, c.getPhoneNumber());
                pstm.setString(5, c.getAddr());
                pstm.setBoolean(6, c.isStatus());
                pstm.setString(7, c.getCompanyId());

                pstm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
