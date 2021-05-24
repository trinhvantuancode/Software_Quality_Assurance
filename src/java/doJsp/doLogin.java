/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doJsp;

import DAO.UserDAO;
import bean.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kakashi
 */
public class doLogin extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Users user = new Users();
            user.setUsername(username);
            user.setPassword(password);
            UserDAO userDAO = new UserDAO();
            Users userResult = userDAO.checkLogin(user);
            HttpSession session = request.getSession();
            
            if (userResult != null) {
                if (request.getParameter("remember") != null) {
                    Cookie usercCookie = new Cookie("CookieUser", username);
                    Cookie passCookie = new Cookie("CookiePass", password);
                    usercCookie.setMaxAge(60 * 60 * 24 * 15);
                    passCookie.setMaxAge(60 * 60 * 24 * 15);
                    response.addCookie(usercCookie);
                    response.addCookie(passCookie);
                }
                session.setAttribute("SessionUser", userResult);
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("OldUsername", username);
                request.setAttribute("OldPassword", password);
                request.setAttribute("errorusername", "Tên đăng nhập không đúng! Vui lòng nhập lại.");
                request.setAttribute("errorpassword", "Mật khẩu không đúng! Vui lòng nhập lại.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } finally {
            out.close();
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
