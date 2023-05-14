/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import com.sun.org.apache.regexp.internal.REUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dao.ProductDAO;
import sample.dao.orderDAO;
import sample.dto.Cart;
import sample.dto.Order;
import sample.dto.Product;
import sample.dto.User;

/**
 *
 * @author duy
 */
public class saveOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String ERROR = "viewcart.jsp";
    public static final String SUCCESS = "viewcart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = ERROR;
            try {
               
                HttpSession session = request.getSession();
                Cart cart = (Cart) session.getAttribute("CART");
                User user = (User) session.getAttribute("LOGIN_USER");
                if(user == null){
                    request.setAttribute("ERROR", "lOGIN truoc khi order");
                    url = "login.jsp";
                } else{
                     boolean checkOrder = false;
                    ProductDAO dao = new ProductDAO();
                    Product prDB = null;
                    for (Product proCart : cart.getCart().values()) {
                        prDB = dao.checkOrder(proCart.getProductID());
                        int quanityDB = prDB.getQuantity();
                        int quanityCart = proCart.getQuantity();
                        if(quanityCart > quanityDB){
                            request.setAttribute("ERROR", "The quantity full");
                            url = ERROR;
                            break;
                        }
                        if(quanityDB > 0){
                            checkOrder = true;
                        } else{
                            checkOrder = false;
                        }
                    }
                    if(checkOrder){
                        String userID = user.getUserID();
                        orderDAO daoOrder = new orderDAO();
                        int checkKQ = daoOrder.insertOrder(userID, cart);
                         
                         boolean checkQuantity = dao.checkQuantity(cart);
                         if(checkKQ > 0 && checkQuantity){
                             url = SUCCESS;
                              request.setAttribute("MESSAGE2", "Order Successfull");
                             session.removeAttribute("CART");
                         } else {
                             request.setAttribute("MESSAGE1", "Quanity max: " + prDB.getQuantity());
                             url = ERROR;
                         }
                    }
                }

            } catch (Exception e) {
                log("Error at saveOrder: " + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }
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
