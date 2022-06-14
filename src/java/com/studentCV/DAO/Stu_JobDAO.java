/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DAO;

import com.studentCV.DTO.Stu_JobDTO;
import com.studentCV.DTO.Stu_MajorDTO;
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
public class Stu_JobDAO {


    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public Stu_JobDAO() {
    }

    private void closeConnection() throws SQLException {
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

    public ArrayList<Stu_JobDTO> getAllStu_Job() throws NamingException, SQLException {

        String sql = "SELECT [Stu_Job]\n"
                + "      ,[StudentId]\n"
                + "      ,[JobId]\n"
                + "  FROM [StudentCV].[dbo].[Stu_Major]";

        ArrayList<Stu_JobDTO> lst = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    int stuId = rs.getInt("StudentId");
                    String majorId = rs.getString("MajorId");

                    StudentDAO stuDao = new StudentDAO();
                    MajorDAO majorDao = new MajorDAO();

                    Stu_MajorDTO stu_major = new Stu_MajorDTO(stuDao.getStudentById(stuId), majorDao.getMajorById(majorId));

                    lst.add(stu_major);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return lst;
    }

    public boolean insert(Stu_MajorDTO stu_major) throws SQLException {
        boolean check = false;
        try {
            String sql = "Insert Into [StudentCV].[dbo].[Stu_Major]"
                    + "(      [StudentId]\n"
                    + "      ,[MajorId])\n"
                    + "Values(?,?)";
            DBUtils db = new DBUtils();
            con = db.makeConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, stu_major.getStudent().getStudentId());
            pstm.setString(2, stu_major.getMajor().getMajorId());

            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }
}

}
