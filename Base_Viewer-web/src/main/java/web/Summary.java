/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import web.pages.TUserForm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wellington
 */

import javax.servlet.http.Cookie;
import web.auth.TAuthCheck;
import web.pages.*;

@WebServlet(name = "Summary", urlPatterns = {"/"})
public class Summary extends HttpServlet {

    
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
        TAuthCheck lAuth = new TAuthCheck( request );
        if(lAuth.checkPassed()){
            
        }
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
        Cookie[] lCookies = request.getCookies();
        TAuthCheck lUser = new TAuthCheck( request );
        String lContent="";
        
        if( lUser.checkPassed() ){
            lContent = ( new TMainPage() ).generateResponse( request );
        }
        
        response.addCookie( new Cookie( TAuthCheck.AUTHTAG, lUser.getCookieValue() ) );
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             out.println( "" );
         //  out.println( System.getProperty("user.dir") );
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
        Cookie[] lCookies = request.getCookies();
        TAuthCheck lUser = new TAuthCheck( request );
        String lContent="";
        
        if( lUser.checkPassed() ){
            lContent = ( new TMainPage() ).generateResponse( request );
        }
        
        response.addCookie( new Cookie( TAuthCheck.AUTHTAG, lUser.getCookieValue() ) );
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             out.println( "" );
         //  out.println( System.getProperty("user.dir") );
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
