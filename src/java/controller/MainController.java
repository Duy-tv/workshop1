/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Duy.Tran
 */
public class MainController extends HttpServlet {

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
            String action = request.getParameter("action");
            String url = "";
            if (action == null) {
                action = Action.HOME;
            }
            switch (action) {
                case Action.HOME:
                    url = "ListProductServlet";
                    break;
                case Action.CONTACT:
                    url = Navigation.CONTACT_URL;
                    break;
                case Action.ADD_NEW:
                    url = Navigation.REGISTER_URL;
                    break;
                case Action.LOGIN:
                    url = Navigation.LOGIN_URL;
                    break;
                case Action.ADD_CATEGORY:
                    url = Navigation.ADD_CATEGORY_URL;
                    break;
                case Action.UPDATE_CATEGORY:
                    url = Navigation.UPDATE_CATEGORY_URL;
                    break;
                case Action.UPDATE:
                    url = Navigation.UPDATE_ACCOUNT_URL;
                    break;
                case Action.ADD_PRODUCT:
                    url = "ListCategoryServlet";
                    break;

                case Action.PRODUCT:
                    url = "ListProductServlet";
                    break;
                case Action.ACCOUNT:
                    url = "ListAccountsServlet";
                    break;
                case Action.REGISTER:
                    url = "RegisterServlet";
                    break;
                case Action.LOGOUT:
                    url = "LogoutServlet";
                    break;
                case Action.UPDATE_ACC:
                    url = "UpdateAccServlet";
                    break;
                case Action.DELETE:
                    url = "DeleteAccServlet";
                    break;
                case Action.ACTIVE:
                    url = "ActiveServlet";
                    break;
                case Action.CATEGORY:
                    url = "ListCategoryServlet";
                    break;
                case Action.ADD_NEW_CATEGORY:
                    url = "AddCategoryServlet";
                    break;
                case Action.EDIT_CATEGORY:
                    url = "UpdateCategoryServlet";
                    break;
                case Action.DELETE_CATEGORY:
                    url = "DeleteCategoryServlet";
                    break;
                case Action.SHOW:
                    url = "ShowProductServlet";
                    break;
                case Action.DELETE_PRODUCT:
                    url = "DeleteProductServlet";
                    break;
                case Action.ADD_NEW_PRODUCT:
                    url = "AddProductServlet";
                    break;
                default:
                    break;
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
