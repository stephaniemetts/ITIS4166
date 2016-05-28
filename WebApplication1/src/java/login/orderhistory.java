/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            
            
            HttpSession userSession = request.getSession();
            User theUser = (User)userSession.getAttribute("session");
            
            if (theUser == null || theUser.equals("")) {
            out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Stephanie's Makeup Store Home Page</title>");   
                        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\">"); //this is linking to a css file
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<ul>");
                        out.println("<li><a href=\"index\">Home Login/Logout</a></li>");
                        out.println("<li><a href=\"registration\">New User</a></li>");
                        out.println("<li><a href=\"content\">Products</a></li>");
                        out.println("<li><a href=\"cart\">Cart</a></li>");
                        out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                        out.println("</ul>");
                out.print("You are not logged in.");
                        out.println("</body>");
                        out.println("</html>");
                        response.sendRedirect("./index");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Stephanie's Makeup Store Home Page</title>");   
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\">"); //this is linking to a css file
                out.println("</head>");
                out.println("<body>");
                out.println("<ul>");
                out.println("<li><a href=\"index\">Home Login/Logout</a></li>");
                out.println("<li><a href=\"registration\">New User</a></li>");
                out.println("<li><a href=\"content\">Products</a></li>");
                out.println("<li><a href=\"cart\">Cart</a></li>");
                out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                out.println("</ul>");
                out.println("Hello, " + theUser.firstName + "!");
                out.println("<h1>Order History</h1>");
        
                out.println("<table align=\"center\">");
                out.println("<tr>");
                  out.println("<th>Order Number</td>");
                  out.println("<th>Item Name</td> ");
                  out.println("<th>Item Quanitity</td>");
                  out.println("<th>Total Price<th>");
                  
                out.println("</tr>");
                //GET ORDERS FROM CARTTABLE
                try
                {
                    // This will load the MySQL driver, each DB has its own driver. You WILL NEED TO INSTALL THE DRIVER or you will get an error at runtime.
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    // Setup the connection with the DB
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/userDatabase"+ "?user=StephanieMetts&password=thePassword");
                    // Statements allow to issue SQL queries to the database
                    Statement statement = connect.createStatement();
                    // Result set get the result of the SQL query
                    ResultSet resultSet = statement.executeQuery("select * from userDatabase.orderHistoryTable where username = '" + theUser.username + "'");
                    
                    int totalSiteCost = 0;
                    int orderCost = 0;
                    int currentCartCost = 0;
                    
                    while(resultSet.next() != false)
                    {
                        int orderNumber = resultSet.getInt("orderNumber");
                        String itemName = resultSet.getString("itemName");
                        int itemQuantities = resultSet.getInt("itemQuantity");
                        int itemPrice = resultSet.getInt("itemPrice");
                        int totalCartCost = resultSet.getInt("totalCartPrice");
                        itemPrice = itemQuantities * itemPrice;
                        totalSiteCost += itemPrice;
                        currentCartCost += itemPrice;
                        out.println("<tr>");
                            out.println("<td>" + orderNumber + "</td>");
                            out.println("<td>" + itemName +"</td>");
                            out.println("<td>" + itemQuantities + "</td>");
                            out.println("<td>" + itemPrice + "</td>");
                        out.println("</tr>");
                        
                        if(currentCartCost == totalCartCost) {
                            out.println("<tr>");
                                out.println("<td>&nbsp</td>");
                                out.println("<td>&nbsp</td>");
                                out.println("<td>Cart Total: </td>");
                                out.println("<td>" + totalCartCost + "</td>");
                            out.println("</tr>");
                            currentCartCost = 0;
                        }
                        
                    }
                    
                    connect.close();
                    
                    out.println("</table><br>");
                    out.println("Total Orders Cost: $" + totalSiteCost);
                }
                catch(Exception e)
                {
                    out.println("DATABASE PROBLEM");
                }
             
                
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

