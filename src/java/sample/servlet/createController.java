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
import sample.dao.userDAO;
import sample.dto.User;
import sample.dto.userError;

/**
 *
 * @author duy
 */
public class createController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            userError error = new userError();
            String url = ERROR;
            try {
                String userID = request.getParameter("userID");
                String fullname = request.getParameter("fullname");
                String roleID = request.getParameter("roleID");
                String password = request.getParameter("password");
                String confirm = request.getParameter("confirm");
                boolean checkValidation = true;
                if(userID.length()<2 || userID.length()>6){
                    error.setUserIDError("UserID must in range 2-6 !");
                    checkValidation = false;
                } 
                boolean checkDupplicate = false;
                userDAO dao = new userDAO();
                checkDupplicate = dao.checkDupplicate(userID);
                if (checkDupplicate){
                    error.setUserIDError("Dupplicate UserID");
                    checkValidation = false;
                }
                if(fullname.length()<5 || fullname.length()>20){
                    error.setFullNameError("fullname must 5-20 word");
                    checkValidation = false;
                }
                if(!password.equals(confirm)){
                    error.setConfirmError("Hai password khong giong nhau");
                    checkValidation = false;
                }
                if (checkValidation){
                    User newUser = new User(userID, fullname, roleID, password);
                    boolean checkInsert = dao.insertV2(newUser);
                    if(checkInsert){
                        url = SUCCESS; 
                    } else {
                        url = ERROR;
                        error.setErrorError("Undefind error");
                        request.setAttribute("USER_ERROR", error);
                    }
                } else {
                    url = ERROR;
                    request.setAttribute("USER_ERROR", error);
                }
            } catch (Exception e) {
                log("Error at createController: " + e.toString());
                if(e.toString().contains("duplicate")){
                    error.setUserIDError("Trung ID roi kia");
                    request.setAttribute("USER_ERROR", error);
                }
            }finally{
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
