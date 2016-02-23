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
public class index extends HttpServlet {

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
            response.setContentType("text/html");
            //PrintWriter out = response.getWriter();
            try {
                out.println("<h1>HTML Servlet</h1>");
            } finally {
                out.close();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
          
              
            if(password == null && email == null || email.equals("") && password.equals("")) 
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Stephanie's Makeup Store Home Page</title>");   
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\">"); //this is linking to a css file
                out.println("</head>");
                out.println("<body>");
                out.println("<ul>");
                out.println("<li><a href=\"index\">Home Login</a></li>");
                out.println("<li><a href=\"registration\">New User</a></li>");
                out.println("<li><a href=\"content\">Products</a></li>");
                out.println("<li><a href=\"cart\">Cart</a></li>");
                out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                out.println("</ul>");
                out.println("<h1>Stephanie's Makeup Store</h1>");
                out.println("<div>Welcome to Stephanie's Makeup Store. We aim to provide high quality products for all of your makeup needs.</div>");
                out.println("<h2>Please Login</h2>");
                out.println("<form action=\"index\" method=\"post\">");
                out.println("Email: <br>");
                out.println("<input name=\"email\" type=\"text\"><br>");
                out.println("Password:  <br><input type=\"text\" name=\"password\"><br>");
                out.println("<br>");
                out.println("<input type=\"submit\" value=\"Submit\">");
                //out.println("<input type=\"submit\" onmouseover=\"colorA(this)\" onmouseout=\"colorB(this)\" value=\"Submit\"><br>");
                out.println("</form>");
                out.println("<a href=\"registration\" onmouseover=\"colorA(this)\" onmouseout=\"colorB(this)\" class =\"button\" >New User?</a>");
                out.println("<script");
                    out.println("function colorA(x){");
                        out.println("x.style.color = \"black\";");
                    out.println("}");
                    out.println("function colorB(x) {");
                        out.println("x.style.color =\"white\";");
                    out.println("}");
                out.println("</script>");  
                out.println("</body>");
                out.println("</html>");
            
            } else {
                out.print("Username = " + email);
                out.println("<br>");
                out.print("Password = " + password);
           }
            
            //edit code below this line
            
            
            
            //for the below two commneted out examples, you will need to import request dispatcher and servlet context. Your ide will probably offer this as a quick fix
          
            //use the below two lines to forward the request to a local servlet. The client (user) will not know this has happened. As tested in class, this will NOT work for external urls.
            ServletContext theContext = this.getServletContext();
            theContext.getRequestDispatcher("index").forward(request, response);
            
           //theContext.setAttribute()
           
            //use the below line to tell the client to redirect to some external (or internal page)
            response.sendRedirect("index");
            
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
