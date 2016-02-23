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
public class cart extends HttpServlet{
    
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
            
            String addMoney = request.getParameter("addmoney");
            String clearCart = request.getParameter("clearcart");
            String checkout = request.getParameter("checkout");
            
              
            if((addMoney == null || addMoney.equals("")) && clearCart == null && checkout == null ) 
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
                    out.println("<h1>User Cart</h1>");
                    out.println("<div>");
                        out.println("<table>");
                            out.println("<tr>");
                              out.println("<th>Item</td>");
                              out.println("<th>Quantity</td>"); 
                              out.println("<th>Price</td>");
                            out.println("</tr>");
                            out.println("<tr>");
                              out.println("<td>Urban Decay Gwen Stefani Palette</td>");
                              out.println("<td>1</td> ");
                              out.println("<td>$45.00</td>");
                            out.println("</tr>");

                          out.println("</table>");
                        out.println("<br>");
                        out.println("Order Total: $45.00");
                    out.println("</div><br>");
                    out.println("<div>");

                    out.println("<form action=\"cart\" method=\"post\">");
                        out.println("<br><input type=\"text\" name=\"addmoney\">");
                        out.println("<input type=\"submit\" value=\"Add Money to Account\"><br>");

                        out.println("<input type=\"submit\" name =\"clearcart\" value =\"Clear Cart\">");
                     out.println("<br>");
                     out.println("<input type=\"submit\" name=\"checkout\" value =\"Checkout\">");
                out.println("</form>");

                out.println("</div>");
                out.println("</form>");
                out.println("</body>"); 
                out.println("</html>");
            } 
            
            else {
                
                if(addMoney == null  || addMoney.equals("") ) {
                    
                    if (clearCart != null ){
                        out.println("Cart Cleared");
                    } else if (checkout != null) {
                        out.println("Checkout");
                    } else {
                    out.println("Money Added: " + addMoney);
                    }
                } else {
                    out.println("Money Added: " + addMoney);
                }
            } 
            //edit code below this line
            
            
            
            //for the below two commneted out examples, you will need to import request dispatcher and servlet context. Your ide will probably offer this as a quick fix
          
            //use the below two lines to forward the request to a local servlet. The client (user) will not know this has happened. As tested in class, this will NOT work for external urls.
            ServletContext theContext = this.getServletContext();
            theContext.getRequestDispatcher("cart").forward(request, response);
            
           
           
            //use the below line to tell the client to redirect to some external (or internal page)
            response.sendRedirect("cart");
            
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
