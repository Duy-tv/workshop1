/*
 * AddProductServlet.java
 * 
 * Servlet responsible for adding new products to the application.
 */
package controller.product;

import controller.Action;
import dao.AccountDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import dto.Account;
import dto.Category;
import dto.Product;
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
public class AddProductServlet extends HttpServlet {
    private static final String UPLOAD = "/images/sanPham";
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
            
            String productId = request.getParameter("productId");
            String productName = request.getParameter("productName");
            String productImage = request.getParameter("productImage");
            String brief = request.getParameter("brief");
            Date postedDate = Date.valueOf(request.getParameter("postedDate"));
            String unit = request.getParameter("unit");
            String typeId = request.getParameter("typeId");
            CategoryDAO cd = new CategoryDAO();
            Category c = cd.getObjectById(String.valueOf(typeId));
            String acc = request.getParameter("account");
            AccountDAO ad = new AccountDAO();
            Account account = ad.getObjectById(acc);
            int price = Integer.parseInt(request.getParameter("price"));
            int discount = Integer.parseInt(request.getParameter("discount"));
            String imgUrl = UPLOAD + "/" + productImage;
            String url = "";
            String message = "";
            ProductDAO productDAO = new ProductDAO();
            Product pro = new Product(productId, productName, imgUrl, brief, postedDate, c, account, unit, price, discount);
            Product checkId = productDAO.getObjectById(productId);

            if (checkId != null || productId.length() > 10) {
                message = "Product Id already exists or has more than 10 characters!";
                request.setAttribute("message", message);
                url = "MainController?action=" + Action.ADD_PRODUCT;

            } else {

                int rs = productDAO.insertRec(pro);
                if (rs >= 1) {
                    url = "MainController?action=" + Action.PRODUCT;
                } else {
                    url = "MainController?action=" + Action.PRODUCT;
                }

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
