/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doJsp;

import DAO.CustomerDAO;
import bean.Customers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kakashi
 */
public class doEditCustomer extends HttpServlet {

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
            String Fullname = request.getParameter("fullname");
            String Firstname = request.getParameter("firstname");
            String Middlename = request.getParameter("middlename");
            String Lastname = request.getParameter("lastname");
            String Address = request.getParameter("address");
            String Phonenumber = request.getParameter("phonenumber");
            String Email = request.getParameter("email");
            String Fromto = request.getParameter("Fromto");
            Customers customers = new Customers(null, Fullname, 
                    Firstname, Middlename, Lastname, Address, Phonenumber, Email, Fromto);
            CustomerDAO customerDAO = new CustomerDAO();
            boolean check = customerDAO.editCustomer(customers);
            if(check) {
                request.getSession().setAttribute("checkedit", true);
            } else {
                request.getSession().setAttribute("checkedit", false);
            }
            response.sendRedirect("doGetCustomer?idsua="+customers.getIdcustomer());
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
