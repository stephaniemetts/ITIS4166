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
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

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
            
            String logout = request.getParameter("logout");
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //String databasePassword;
            boolean verified = false;
            
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
            out.println("<h1>Stephanie's Makeup Store</h1>");
            out.println("<div>Welcome to Stephanie's Makeup Store. We aim to provide high quality products for all of your makeup needs.</div>");
            out.println("<br>");
            out.println("</body>");
            out.println("</html>");
            
          
            if(logout != null ) {
                HttpSession UserSession = request.getSession();
                UserSession.invalidate();
                response.sendRedirect("./");

            } else { //logout is equal to null 
                HttpSession UserSession = request.getSession();
                User checkUser = (User)UserSession.getAttribute("session");
                
                if(checkUser == null || checkUser.equals("")) { //there is no cookie
                    //out.println("The session is null");
                    if(password == null || password.equals("") && username == null || username.equals("")) { //the user has not entered anything
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<body>");
                        out.println("<h2>Please Login</h2>");
                        out.println("<form action=\"index\" method=\"post\">");
                        out.println("Username: <br>");
                        out.println("<input name=\"username\" type=\"text\"><br>");
                        out.println("Password:  <br><input type=\"text\" name=\"password\"><br>");
                        out.println("<br>");
                        out.println("<input type=\"submit\" value=\"Submit\">");
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

                    } else { //the user has entered information
                        //if the input parameters match a user object parameter - else put an error message saying that the items do not match {
                        
                        
                        if(username == null || username.equals("")) {
                            out.println("Please enter a username.");
                        } else if(password == null || password.equals("")) {
                            out.println("Please enter a password.");
                        } else {
                        
                        try {
                            // This will load the MySQL driver, each DB has its own driver. You WILL NEED TO INSTALL THE DRIVER or you will get an error at runtime.
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            // Setup the connection with the DB
                            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/userDatabase"+ "?user=StephanieMetts&password=thePassword");
                            // Statements allow to issue SQL queries to the database
                            Statement statement = connect.createStatement();
                            // Result set get the result of the SQL query
                            ResultSet resultSet = statement.executeQuery("select * from userDatabase.userTable where username = '" + username + "';");
                            while(resultSet.next() != false)
                            {
                                verified = true;
                                String databasePassword = resultSet.getString("password");
                                String databaseFirstName = resultSet.getString("firstName");
                                String databaseLastName = resultSet.getString("lastName");
                                String databaseEmail = resultSet.getString("email");
                                int databaseBalance = resultSet.getInt("balance");
                                String databaseGender = resultSet.getString("gender");
                                
                                if(databasePassword.equals(password) && ( password != null || !password.equals(""))) {
                                    out.println("Hello, " + databaseFirstName + ". You have logged in."); //javascript and redirect to content page 1
                                    //HttpSession userSession = request.getSession();
                                    //userSession.setAttribute("session", testUser);
                                    //write to the session
                                    
                                    UserBean theUserBean = new UserBean();
                                    theUserBean.setFirstName(databaseFirstName);
                                    theUserBean.setLastName(databaseLastName);
                                    theUserBean.setUsername(username);
                                    theUserBean.setEmail(databaseEmail);
                                    theUserBean.setPassword(password);
                                    theUserBean.setBalance(databaseBalance);
                                    theUserBean.setGender(databaseGender);
                                    
                                    //out.println("The user bean password: " + theUserBean.getPassword());
                                    
                                    HttpSession userSession = request.getSession();
                                    
                                    userSession.setAttribute("beanSession", theUserBean);
                                            
                                    
                                    out.println("<a href=\"otherViewRedirect\">Other View/User Information</a>");
                                    
                                    /*
                                    request.setAttribute("beanSession", theUserBean);
                                    
                                    ServletContext theContext = this.getServletContext();
                                    theContext.getRequestDispatcher("/otherView.jsp").forward(request, response);
                                    */
                                    User aUser = new User();

                                    aUser.firstName = databaseFirstName;
                                    aUser.lastName = databaseLastName;
                                    aUser.balance = databaseBalance;
                                    aUser.username = username;

                                    UserMap.theUserMap.put(username, aUser);
                                    
                                    
                                    userSession.setAttribute("session", aUser);
                                    
                                } else {
                                    out.println ("User name or password is incorrect.<br>");
                                    out.println("<!DOCTYPE html>");
                                    out.println("<html>");
                                    out.println("<body>");
                                    out.println("<h2>Please Login</h2>");
                                    out.println("<form action=\"index\" method=\"post\">");
                                    out.println("Username: <br>");
                                    out.println("<input name=\"username\" type=\"text\"><br>");
                                    out.println("Password:  <br><input type=\"text\" name=\"password\"><br>");
                                    out.println("<br>");
                                    out.println("<input type=\"submit\" value=\"Submit\">");
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
                                }
                                
                            }
                            
                             if(verified == false) {
                                    
                                    out.println ("User name or password is incorrect.<br>");
                                    out.println("<!DOCTYPE html>");
                                    out.println("<html>");
                                    out.println("<body>");
                                    out.println("<h2>Please Login</h2>");
                                    out.println("<form action=\"index\" method=\"post\">");
                                    out.println("Username: <br>");
                                    out.println("<input name=\"username\" type=\"text\"><br>");
                                    out.println("Password:  <br><input type=\"text\" name=\"password\"><br>");
                                    out.println("<br>");
                                    out.println("<input type=\"submit\" value=\"Submit\">");
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
                                }
                            
                            connect.close();
                            
                        }
                        catch(Exception e)
                        {
                            out.println("DATABASE PROBLEM");
                        }
                        }
                   }
                } else { //user is logged in
                    out.println("Hello, " + checkUser.firstName + ". You are logged in.");
                    out.println("<form action =\"index\" method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"logout\" value=\"leaving\">");
                    out.println("<input type=\"submit\" value=\"Logout\">");
                    out.println("</form>");
                    
                                    out.println("<br><a href=\"otherViewRedirect\">Other View/User Information</a>");
                    
                    //HttpSession userSession = request.getSession();
                    //userSession.getAttribute("beanSession");
                    //userSession.setAttribute("beanSession", theUserBean);
                                    
                    
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
