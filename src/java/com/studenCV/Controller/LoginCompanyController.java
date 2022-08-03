/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.studenCV.Controller;


import com.studentCV.DAO.CompanyDAO;
import com.studentCV.DTO.CompanyDTO;
import com.studentCV.DTO.UserGoogleDTO;
import com.studentCV.utils.GoogleUtils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author ADMIN
 */
@WebServlet(name="LoginCompanyController", urlPatterns={"/LoginCompanyController"})
public class LoginCompanyController extends HttpServlet {
    private final String HOME_PAGE = "index.jsp";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String code = request.getParameter("code");
        String url = HOME_PAGE;
        try {
            if (code == null || code.isEmpty()) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                String accessToken = GoogleUtils.getToken(code);
// edit bua
                UserGoogleDTO googlePojo = GoogleUtils.getUserInfo(accessToken);
                request.setAttribute("id", googlePojo.getId());
                request.setAttribute("name", googlePojo.getName());
                request.setAttribute("email", googlePojo.getEmail());
                System.out.println("email:" + googlePojo.getEmail());
                System.out.println(googlePojo.getId());
                System.out.println(googlePojo.getName());
                
                //CompanyDAO dao = new CompanyDAO();
                //CompanyDTO dto = dao.getCompanyByEmail(googlePojo.getEmail());
                /*
                if (dao != null) {
                    session.setAttribute("COMPANY", sDto);
                } else {
                    //StudentDTO std = new StudentDTO(googlePojo.getEmail());
                    //sDao.insert(std);
                    //session.setAttribute("COMPANY", std);
                }
                */
            }
        } catch (Exception ex) {
            log("LoginCompanyController   _ Exception " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }

    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
