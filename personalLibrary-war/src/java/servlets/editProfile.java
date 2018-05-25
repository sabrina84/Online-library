/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db.DataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "editProfile", urlPatterns = {"/editProfile.do"})
public class editProfile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("username");
        if(username==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
        else{
            DataAccess db = new DataAccess();
            
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
       /*  if(password==null)password=db.getPass(username);
         else{
              int c ;
        c= check(password,password1);
        if(c==0){
            RequestDispatcher rd = request.getRequestDispatcher("editProfile2.jsp");
                rd.forward(request, response); 
        }
         }*/
        String phone = request.getParameter("phone");
        
      /*   if(email==null)email=db.getMail(username);
         else{
              int c ;
        c= check(email,email1);
        if(c==0){
            RequestDispatcher rd = request.getRequestDispatcher("editProfile2.jsp");
                rd.forward(request, response); 
        }
         }*/
           int c ;
        c= check(password,password1);
        if(c==0){
            RequestDispatcher rd = request.getRequestDispatcher("editProfile2.jsp");
                rd.forward(request, response); 
        }
        else{
            int b = db.updateProfile(username, password, phone);
            if(b>0){
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
                rd.forward(request, response); 
            }
        }
        }
        }
    public  int check(String p, String p1) {
            if((p.equals(p1)))return 1;
            return 0;
       }
     
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(editProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(editProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}