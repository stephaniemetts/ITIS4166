/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tyler
 */
public class registration extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>This is to see if the servlet works " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String firstnameS = request.getParameter("firstname");
            String lastnameS = request.getParameter("lastname");
            String usernameS = request.getParameter("username");
            String passwordS = request.getParameter("password");
            String emailS = request.getParameter("email");
            String email2S = request.getParameter("email2");
            String genderS = request.getParameter("gender");
            
            if(firstnameS == null && lastnameS == null && usernameS == null && passwordS == null
                   && emailS == null && email2S == null && genderS == null ) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registration Page</title>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<ul>");
                    out.println("<li><a href=\"index\">Home Login</a></li>");
                    out.println("<li><a href=\"registration\">New User</a></li>");
                    out.println("<li><a href=\"content\">Products</a></li>");
                    out.println("<li><a href=\"cart\">Cart</a></li>");
                    out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                out.println("</ul>");
                out.println("<h1>Please Sign Up</h1>");
                out.println("<form action=\"registration\" method= \"post\">");
                out.println("First Name: <br><input type=\"text\" name=\"firstname\"><br>");
                out.println("Last Name: <br><input type=\"text\" name=\"lastname\" ><br>");
                out.println("User Name: <br><input type=\"text\" name=\"username\" ><br>");
                out.println("Email: <br><input type=\"text\" name=\"email\"><br>");
                out.println("Re-enter Email: <br><input type=\"text\" name=\"email2\" ><br>");
                out.println("Password:  <br><input type=\"password\" name=\"password\" ><br>");
                out.println("Gender: <br>");
                    out.println("<input type=\"radio\" name=\"gender\" value=\"male\" checked> Male");
                    out.println("<input type=\"radio\" name=\"gender\" value=\"female\"> Female");
                    out.println("<input type=\"radio\" name=\"gender\" value=\"noanswer\"> Prefer Not to Answer<br>");

                out.println("<input type=\"submit\" value=\"Submit\" ><br>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            } else {
                out.println("First Name: " + firstnameS + "<br>");
                out.println("Last Name: " + lastnameS + "<br>");
                out.println("Username: " + usernameS + "<br>");
                out.println("Password: " + passwordS + "<br>");
                out.println("Email: " + emailS + "<br>");
                out.println("Email Verification: " + email2S + "<br>");
                out.println("Gender: " + genderS + "<br>");
            }
            
            //for the below two commneted out examples, you will need to import request dispatcher and servlet context. Your ide will probably offer this as a quick fix
          
            //use the below two lines to forward the request to a local servlet. The client (user) will not know this has happened. As tested in class, this will NOT work for external urls.
            // ServletContext theContext = this.getServletContext();
           // theContext.getRequestDispatcher("someLocalServlet").forward(request, response);
            
           
           
            //use the below line to tell the client to redirect to some external (or internal page)
            //response.sendRedirect("http://www.google.com");
            
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
        doGet(request, response);
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
