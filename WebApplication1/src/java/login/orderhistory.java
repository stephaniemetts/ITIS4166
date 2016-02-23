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
 * @author stephanie
 */
public class orderhistory extends HttpServlet{
    
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
            
            
            
              
            //if(password == null || email == null || email.equals("") || password.equals("")) 
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
                
                out.println("<h1>Order History</h1>");
        
                out.println("<table align=\"center\">");
                out.println("<tr>");
                  out.println("<th>Order Date</td>");
                  out.println("<th>Order Number</td> ");
                  out.println("<th>Total Price</td>");
                out.println("</tr>");
                out.println("<tr>");
                  out.println("<td>1/26/2015</td>");
                  out.println("<td>4584AXG</td> ");
                  out.println("<td>$45.00</td>");
                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td>3/28/1992</td>");
                    out.println("<td>3425IUS</td>");
                    out.println("<td>$325.00</td>");
                out.println("</tr>");
             
              out.println("</table>");
                
                out.println("</div>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } 
            
            //edit code below this line
            
            
            
            //for the below two commneted out examples, you will need to import request dispatcher and servlet context. Your ide will probably offer this as a quick fix
          
            //use the below two lines to forward the request to a local servlet. The client (user) will not know this has happened. As tested in class, this will NOT work for external urls.
            //ServletContext theContext = this.getServletContext();
            //theContext.getRequestDispatcher("index.java").forward(request, response);
            
           
           
            //use the below line to tell the client to redirect to some external (or internal page)
            //response.sendRedirect("index");
            
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

