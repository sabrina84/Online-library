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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.bookList;
import models.rentedList;


/**
 *
 * @author Lenovo
 */
@WebServlet(name = "login", urlPatterns = {"/login.do"})
public class login extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        System.out.println("in processRequest");
        
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         System.out.println(username+" "+password);

        DataAccess db = new DataAccess();
        if(username.contains("admin")){
            
            System.out.println(123);
            boolean exist = db.existUserAd(username, password);
        if(exist)
      {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
            rd.forward(request, response);
       }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
        }
        
        
        else{
        boolean exist = db.existUser(username, password);
        if(exist)
      {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
       }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
        }
    }
  public static void main(String[] args) throws SQLException{
            DataAccess db = new DataAccess();
          //String l;
        // l = db.getStudentName("nowrin","123");
        //    int n;
           // n = db.createAccount("maleha", "alam", "maleha", "maleha1", "maleha@gmail.com");
            //System.out.println(l);
           ArrayList<rentedList> lst = (ArrayList<rentedList>)db.getRentedList();
      
     //    if(lst.size() <10 ){
           for(rentedList item: lst){
               System.out.println(item.getName()+" "+item.getDate());
           }
          //  System.out.println(123);
              // n = db.prepareExam("e4phy1","1.freezing temperature of water-", "e1", "phy", "a)0k b)273k");
             //  System.out.println(n);
        
            //int a=db.addResult("c1", "nowrin", "40");
            //String a = db.getMail("jabir");
            //System.out.println(a);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
