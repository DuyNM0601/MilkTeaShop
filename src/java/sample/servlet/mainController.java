/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duy
 */
public class mainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final static String ERROR = "error.jsp";
    private final static String WELCOME = "login.jsp";
    private final static String LOGIN = "Login";
    private final static String LOGIN_CONTROLLER = "LoginController";
    private final static String SEARCH_CONTROLLER = "SearchController";
    private final static String SEARCH = "Search";
    private final static String LOGOUT = "logout";
    private final static String LOGOUT_CONTROLLER = "LogoutController";
    private final static String DELETE = "Delete";
    private final static String DELETE_CONTROLLER = "deleteController";
    private final static String UPDATE = "Update";
    private final static String UPDATE_CONTROLLER = "updateController";
    private final static String CREATE = "create";
    private final static String CREATE_CONTROLLER = "createController";
    private final static String GET_ALL = "getall";
    private final static String GETALL_CONTROLLER = "getallController";
    private final static String ADD = "Add";
    private final static String ADD_CONTROLLER = "addController";
    private final static String VIEWCART = "viewcart";
    private final static String VIEWCART_JSP = "viewcart.jsp";
    private final static String EDIT = "edit";
    private final static String EDIT_CONTROLLER = "editController";
    private final static String REMOVE = "remove";
    private final static String REMOVE_CONTROLLER = "removeController";
    private final static String ORDER = "Order";
    private final static String SEARCHORDER_CONTROLLER = "saveOrder";
    private final static String ORDERDETAIL = "Order Details";
    private final static String USER = "User";
    private final static String USER_CONTROLLER = "UserController";
    private final static String ORDERDETAIL_CONTROLLER = "searchOrderController";
    private static final String LOGIN_GMAIL = "Login With Google";
    private static final String LOGIN_GMAIL_PAGE = "https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri="
            + "http://localhost:8084/PRJ301_BL3_SP23_JSTL/LoginGmailController&response_type=code"
            + "&client_id=97635408020-lspt52okpq7qq5q5rmgirnjfhao8cak1.apps.googleusercontent.com"
            + "&approval_prompt=force";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = ERROR;
            try {
                String action = request.getParameter("action");
                if (action == null) {
                    url = WELCOME;
                } else if (LOGIN.equals(action)) {
                    url = LOGIN_CONTROLLER;
                } else if (SEARCH.equals(action)) {
                    url = SEARCH_CONTROLLER;
                } else if (LOGOUT.equals(action)) {
                    url = LOGOUT_CONTROLLER;
                } else if (DELETE.equals(action)) {
                    url = DELETE_CONTROLLER;
                } else if (UPDATE.equals(action)) {
                    url = UPDATE_CONTROLLER;
                } else if (CREATE.equals(action)) {
                    url = CREATE_CONTROLLER;
                } else if (GET_ALL.equals(action)) {
                    url = GETALL_CONTROLLER;
                } else if (VIEWCART.equals(action)) {
                    url = VIEWCART_JSP;
                } else if (ADD.equals(action)) {
                    url = ADD_CONTROLLER;
                } else if (EDIT.equals(action)) {
                    url = EDIT_CONTROLLER;
                } else if (REMOVE.equals(action)) {
                    url = REMOVE_CONTROLLER;
                } else if (ORDER.equals(action)) {
                    url = SEARCHORDER_CONTROLLER;
                } else if (LOGIN_GMAIL.equals(action)) {
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", LOGIN_GMAIL_PAGE);
                } else if(ORDERDETAIL.equals(action)){
                    url = ORDERDETAIL_CONTROLLER;
                }else if(USER.equals(action)){
                    url = USER_CONTROLLER;
                }
            } catch (Exception e) {
                log("Error at Maincontroller: " + e.toString());
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
