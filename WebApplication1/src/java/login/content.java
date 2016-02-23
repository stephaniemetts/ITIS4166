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
public class content extends HttpServlet{
    
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
            
            
            String itemName= request.getParameter("item");
            String itemQuantity = request.getParameter("quantity");
            String itemPrice = request.getParameter("price");
              
            if(itemName == null || itemName.equals("")) 
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
                
                out.println("<h2> 6 Product Results</h2>");
                
                out.println("<div>");
                 out.println("<img src=\"http://www.sephora.com/productimages/sku/s1776178-main-hero-300.jpg\" alt=\"Gwen Stefani Blush Palette\" style=\"width:200px;height:200px;\">"); 
                 out.println("<p>Urban Decay");
                     out.println("<form action=\"content\" method=\"post\">");
                     out.println("<br>");
                     out.println("<input name=\"item\" value=\"Gwen Stefani Blush Palette\"> ");
                     out.println("<br>");
                     out.println("This limited edition palette was made by Urban Decay in collaboration with Gwen Stefani. This palette features");
                     out.println("six limited edition shades all in one palette.");
                     out.println("<br>");
                     out.println("<input name=\"price\" value = \"45.00\">");
                     out.println("<br>");
                     out.println("Quanitity: ");
                     out.println("<input type =\"text\" name=\"quantity\" value=\"1\">");
                     out.println("<br>");
                     out.println("<br>");
                     out.println("<input type=\"submit\" value =\"Add to Cart\">");
                     out.println("</form>");
                     //out.println("<input type=\"submit\" value=\"Add to Cart\">");
                     //out.println("<input type=\"button\" name=\"gwenblush\" value=\"Add to Cart\">");
                 out.println("</p>");
                out.println("</div>");
                
                out.println("<div>");
                out.println("<img src=\"http://www.sephora.com/productimages/sku/s1771047-main-hero-300.jpg\" alt=\"Too Faced Chocolate Bon Bons\" style=\"width:200px;height:200px;\">"); 
                out.println("<p>");
                    out.println("Too Faced");
                     out.println("<form action=\"content\" method=\"post\">");
                    out.println("<br>");
                     out.println("<input name=\"item\" value=\"Chocolate Bon Bons Palette\"> ");
                    out.println("<br>");
                    out.println("This eyeshadow palette offers 16 all new shades in a cute palette that smells like chocolate.");
                    out.println("<br>");
                     out.println("<input name=\"price\" value = \"$49.00\">");
                    out.println("<br>");out.println("Quanitity: ");
                     out.println("<input type =\"text\" name=\"quantity\" value=\"1\">");
                     out.println("<br>");
                     out.println("<input type=\"submit\" value =\"Add to Cart\">");
                    out.println("</form>");
                out.println("</p>");
                out.println("</div>");
                
                out.println("<br>");
                out.println("<br>");
                
                out.println("<div>");
                out.println("<p>");
                    out.println("<img src=\"http://www.sephora.com/productimages/sku/s1775006-main-hero-300.jpg\" alt=\"tarte Tartlette in Bloom\" style=\"width:200px;height:200px;\">");
                    out.println("<br>");
                    out.println("tarte");
                     out.println("<form action=\"content\" method=\"post\">");
                    out.println("<br>");
                     out.println("<input name=\"item\" value=\"Tartlette in Bloom Palette\"> ");
                    out.println("<br>");
                    out.println("This eyeshadow palette contains 12 new shades containing matte and shimmer finishes.");
                    out.println("<br>");
                     out.println("<input name=\"price\" value = \"$45.00\">");
                    out.println("<br>");
                    out.println("Quanitity: ");
                     out.println("<input type =\"text\" name=\"quantity\" value=\"1\">");
                     out.println("<br>");
                     out.println("<input type=\"submit\" value =\"Add to Cart\">");
                    out.println("</form>");
                out.println("</p>");
                out.println("</div>");
                out.println("<div>");
                out.println("<img src=\"http://www.sephora.com/productimages/sku/s1615186-main-hero-300.jpg\" alt=\"Anastasia Contour\" style=\"width:200px;height:200px;\">   ");
                 out.println("<p>Anastasia Beverly Hills");
                     out.println("<br>");
                     out.println("<form action=\"content\" method=\"post\">");
                     out.println("<input name=\"item\" value=\"Pro Contour Palette\"> ");
                     out.println("<br>");
                     out.println("This palette contains six shades in order to make contouring a breeze. The set contains 3 contour shades and 3 highlight shades.");
                     out.println("<br>");
                     out.println("<input name=\"price\" value = \"$40.00\">");
                     out.println("<br>");
                     out.println("Quanitity: ");
                     out.println("<input type =\"text\" name=\"quantity\" value=\"1\">");
                     out.println("<br>");
                     out.println("<input type=\"submit\" value =\"Add to Cart\">");
                    out.println("</form>");
                out.println("</p>");
                out.println("</div>");
                out.println("<br>");
                out.println("<br>");
                out.println("<div>");
                out.println("<img src=\"http://www.sephora.com/productimages/sku/s1606086-main-hero-300.jpg\" alt=\"Hourglass Ambient Light\" style=\"width:200px;height:200px;\">");
                out.println("<p>");
                    out.println("Hourglass");
                     out.println("<form action=\"content\" method=\"post\">");
                    out.println("<br>");
                     out.println("<input name=\"item\" value=\"Ambient Light Palette\"> ");
                    out.println("<br>");
                    out.println("This highlighting palette gives a luminous glow when applied to the cheeks.");
                    out.println("<br>");
                     out.println("<input name=\"price\" value = \"$58.00\">");
                    out.println("<br>");
                    out.println("Quanitity: ");
                     out.println("<input type =\"text\" name=\"quantity\" value=\"1\">");
                     out.println("<br>");
                     out.println("<input type=\"submit\" value =\"Add to Cart\">");
                    out.println("</form>");
                     out.println("<br>");
                out.println("</p>");
                out.println("</div>");
                out.println("<div>");
                out.println("<p>");
                    out.println("<img src=\"http://www.sephora.com/productimages/sku/s1721232-main-hero-300.jpg\" alt=\"Becca Ombre Rouge\" style=\"width:200px;height:200px;\">");
                    out.println("<br>");
                    out.println("Becca");
                     out.println("<form action=\"content\" method=\"post\">");
                    out.println("<br>");
                     out.println("<input name=\"item\" value=\"Ombre Rouge Palette\"> ");
                    out.println("<br>");
                    out.println("This eyeshadow palette contains 5 matte shades perfect for everyday wear.");
                    out.println("<br>");
                     out.println("<input name=\"price\" value = \"$40.00\">");
                    out.println("<br>");
                    out.println("Quanitity: ");
                     out.println("<input type =\"text\" name=\"quantity\" value=\"1\">");
                     out.println("<br>");
                     out.println("<input type=\"submit\" value =\"Add to Cart\">");
                    out.println("</form>");
                    out.println("<br>");
                out.println("</p>");
                out.println("</div>");
                out.println("<br>");
                out.println("<br>");
               // out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.print("Item:  " + itemName + " Item Price: " + itemPrice + " Item Quantity: " + itemQuantity );
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
