/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duy.Tran
 */
public class UpdateAccServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");
            String account = request.getParameter("account");
            String password = request.getParameter("password");
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String phone = request.getParameter("phone");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            boolean gender = request.getParameter("gender").equals("1");
            boolean isUse = request.getParameter("isUse").equals("1");
            int roleInSystem = Integer.parseInt(request.getParameter("roleInSystem"));
            String message = "";
            String url = "";

            boolean isValidPhone = phone.matches("^(03|05|07|08|09)\\d{8}$");
            
            Account obj = new Account(account, password, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
            AccountDAO acc = new AccountDAO();

            Account checkAccount = acc.checkAcc(account);
            if (checkAccount != null) {
                if (!isValidPhone) {
                    message = "Phone number must be digit and begin with 03|05|07|08|09";
                    request.setAttribute("message", message);
                    url = Action.UPDATE_ACCOUNT_URL;
                } else {
                    int rs = acc.updatetRec(obj);
                    if (rs >= 1) {
                        url = "MainController?action=" + Action.ACCOUNT;
                    } else {
                        url = "MainController?action=" + Action.ACCOUNT;
                    }
                }
            } else {
                url = "error404.html";
            }
            request.getRequestDispatcher(url).forward(request, response);
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
