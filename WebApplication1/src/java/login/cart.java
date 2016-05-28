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
            
            HttpSession userSession = request.getSession();
            User theUser = (User)userSession.getAttribute("session");
            
            String addMoney = request.getParameter("addmoney");
            String clearCart = request.getParameter("clearcart");
            String checkout = request.getParameter("checkout");
            double cartTotal = 0.00;
            
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
                out.println("Hello, " + theUser.firstName + "!");
                out.println("<br>");
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
                    out.println("<li><a href=\"index\">Home Login/Logout</a></li>");
                    out.println("<li><a href=\"registration\">New User</a></li>");
                    out.println("<li><a href=\"content\">Products</a></li>");
                    out.println("<li><a href=\"cart\">Cart</a></li>");
                    out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                    out.println("</ul>");
                    out.println("<h1>User Cart</h1>");
                    out.println("<table align=\"center\">");
                            out.println("<tr>");
                              out.println("<th>Item</th>");
                              out.println("<th>Quantity</th>"); 
                              out.println("<th>Price</th>");
                              out.println("<th>Item Cost</th>");
                            out.println("</tr>");
                                for(int i=0;i<10;i++) {
                                    if(theUser.items[i] != null ) {
                                        out.println("<tr>");
                                        out.println("<td>" + theUser.items[i] + "</td>");
                                        out.println("<td>" + theUser.quantities[i] + "</td>");
                                        out.println("<td>" + theUser.prices[i] + "</td>");
                                        out.println("<td>" + theUser.prices[i] * theUser.quantities[i] + "</td>");
                                        out.println("</tr>");
                                        
                                    }
                                } 
                            
                          out.println("</table>");
                        out.println("<br>");
                        out.println("Order Total: $" + theUser.cartTotal);
                        //PULL FROM DATABASE
                        
                        try
                        {
                            // This will load the MySQL driver, each DB has its own driver. You WILL NEED TO INSTALL THE DRIVER or you will get an error at runtime.
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            // Setup the connection with the DB
                            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/userDatabase"+ "?user=StephanieMetts&password=thePassword");
                            // Statements allow to issue SQL queries to the database
                            Statement statement = connect.createStatement();
                            // Result set get the result of the SQL query
                            ResultSet resultSet = statement.executeQuery("select balance from userDatabase.userTable WHERE username = '" + theUser.username + "'" );
                            while(resultSet.next() != false)
                            {
                                int databaseBalance = resultSet.getInt("balance");

                                out.println("Money in Balance: $" + databaseBalance + "<br/>");
                            }
                            connect.close();
                        }
                        catch(Exception e)
                        {
                            out.println("DATABASE PROBLEM");
                        }
                        
                    out.println("<br>");

                    out.println("<form action=\"cart\" method=\"post\">");
                        out.println("<br><input type=\"text\" name=\"addmoney\">");
                        out.println("<input type=\"submit\" value=\"Add Money to Account\"><br>");
                    out.println("</form>");
                    out.println("<form action=\"cart\" method=\"post\">");
                        out.println("<input type=\"submit\" name =\"clearcart\" value =\"Clear Cart\">");
                        out.println("<br>");
                        out.println("<input type=\"submit\" name=\"checkout\" value =\"Checkout\">");
                    out.println("</form>");

                out.println("</form>");
                out.println("</body>"); 
                out.println("</html>");
                } else {
                    if(clearCart != null) {
                        out.print("Cart Cleared");
                        for(int i=0;i<10;i++) {
                            theUser.items[i] = null;
                            theUser.quantities[i] = 0;
                            theUser.prices[i] = 0.0;
                            
                        }
                        theUser.cartTotal = 0.0;
                    } else if(checkout != null) {
                        if(theUser.balance >= theUser.cartTotal) {
                            out.println("You have checked out.");
                            //SEND ORDER TO ORDERHISTORY DATABASE
                            
                            try {
                                // This will load the MySQL driver, each DB has its own driver. You WILL NEED TO INSTALL THE DRIVER or you will get an error at runtime.
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                // Setup the connection with the DB
                                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/userDatabase"+ "?user=StephanieMetts&password=thePassword");
                                // Statements allow to issue SQL queries to the database
                                Statement statement = connect.createStatement();
                                // Result set get the result of the SQL query
                                int a;
                                int totalQuantity = 0;
                                int itemCount = 0;
                                for(a=0; a<10; a++) {
                                    if(theUser.quantities[a] > 0) {
                                        itemCount++;
                                    }
                                }
                                
                                
                                ResultSet resultSet = statement.executeQuery("select orderNumber from userDatabase.orderHistoryTable where username = '" + theUser.username + "'");
                                int databaseLastCartID = 0;
                                while(resultSet.next() != false)
                                {
                                    databaseLastCartID = resultSet.getInt("orderNumber");
                                }
                                int currentCartID = databaseLastCartID + 1;
                                
                                int z;
                                for(z=0; z<itemCount; z++){
                                    statement.executeUpdate("insert into userDatabase.orderHistoryTable (orderNumber, username, itemName, itemQuantity, itemPrice, totalCartPrice) VALUES ("+ "'" + currentCartID + "', '" + theUser.username + "'" + "," +  "'" + theUser.items[z] +  "'" + ", " + "'" + theUser.quantities[z] + "'" + ", " + "'" + theUser.prices[z] + "', '" + theUser.cartTotal + "');");
                                                           
                                    
                                }
                                  
                                
                                connect.close();
                            }
                            catch(Exception e)
                            {
                                out.println("DATABASE PROBLEM");
                                e.printStackTrace();
                            }
                            
                            theUser.balance -= theUser.cartTotal;
                            //UPDATE USER BALANCE IN DATABASE
                            
                            try {
                                // This will load the MySQL driver, each DB has its own driver. You WILL NEED TO INSTALL THE DRIVER or you will get an error at runtime.
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                // Setup the connection with the DB
                                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/userDatabase"+ "?user=StephanieMetts&password=thePassword");
                                // Statements allow to issue SQL queries to the database
                                Statement statement = connect.createStatement();
                                // Result set get the result of the SQL query
                                
                                    statement.executeUpdate("update userDatabase.userTable set balance =  " + "'" + theUser.balance + "'"  +  " where username = '" + theUser.username + "';");
                                

                                connect.close();
                            }
                            catch(Exception e)
                            {
                                out.println("DATABASE PROBLEM");
                                e.printStackTrace();
                            }
                            
                            for(int i=0;i<10;i++) {
                                theUser.items[i] = null;
                                theUser.quantities[i] = 0;
                                theUser.prices[i] = 0.0;
                            }
                            theUser.cartTotal = 0.0;
                        } else {
                                out.println ("<html><body><script>document.write(\"You do not have enough money to checkout.\");</script></body></html>");
                        }
                    } else if(addMoney != null || !addMoney.equals("")) {
                        theUser.balance += Double.parseDouble(addMoney);
                                out.println ("<html><body><script>document.write(\"The following funds have been added:<br>\" + theUser.balance );</script></body></html>");
                                //ADD MONEY TO BALANCE IN USERTABLE
                                
                                try {
                                // This will load the MySQL driver, each DB has its own driver. You WILL NEED TO INSTALL THE DRIVER or you will get an error at runtime.
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                // Setup the connection with the DB
                                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/userDatabase"+ "?user=StephanieMetts&password=thePassword");
                                // Statements allow to issue SQL queries to the database
                                Statement statement = connect.createStatement();
                                // Result set get the result of the SQL query
                                
                                    statement.executeUpdate("update userDatabase.userTable set balance =  " + "'" + theUser.balance + "'"  +  " where username = '" + theUser.username + "';");
                                
                                connect.close();
                                }
                                catch(Exception e)
                                {
                                    out.println("DATABASE PROBLEM");
                                    e.printStackTrace();
                                }
                        
                    }
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
                    out.println("<h1>User Cart</h1>");
                    out.println("<table align=\"center\">");
                            out.println("<tr>");
                              out.println("<th>Item</th>");
                              out.println("<th>Quantity</th>"); 
                              out.println("<th>Price</th>");
                              out.println("<th>Item Cost</th>");
                            out.println("</tr>");
                            if(theUser.items[0] != null) {
                                for(int i=0;i<10;i++) {
                                    if(theUser.items[i] != null) {
                                    out.println("<tr>");
                                        out.println("<td>" + theUser.items[i] + "</td>");
                                        out.println("<td>" + theUser.quantities[i] + "</td>");
                                        out.println("<td>" + theUser.prices[i] + "</td>");
                                        out.println("<td>" + theUser.prices[i] * theUser.quantities[i] + "</td>");
                                        //theUser.cartTotal += (theUser.quantities[i] * theUser.prices[i]);
                                    out.println("</tr>");
                                        
                                    }
                                } 
                            }
                            
                          out.println("</table>");
                        out.println("<br>");
                        out.println("Order Total: $" + theUser.cartTotal);
                        out.println("<br>Money in Balance: $" + theUser.balance +"<br>");
                    out.println("<br>");

                    out.println("<form action=\"cart\" method=\"post\">");
                        out.println("<br><input type=\"text\" name=\"addmoney\">");
                        out.println("<input type=\"submit\" value=\"Add Money to Account\"><br>");
                    out.println("</form>");
                    out.println("<form action=\"cart\" method=\"post\">");
                        out.println("<input type=\"submit\" name =\"clearcart\" value =\"Clear Cart\">");
                        out.println("<br>");
                        out.println("<input type=\"submit\" name=\"checkout\" value =\"Checkout\">");
                    out.println("</form>");

                out.println("</form>");
                out.println("</body>"); 
                out.println("</html>");
                }
            }
            
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
