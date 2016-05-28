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
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>");
            out.println("<script src=\"javascriptFile.js\"></script>");
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
            
            HttpSession UserSession = request.getSession();
            
            User theUser = (User)UserSession.getAttribute("session");
            
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String email2 = request.getParameter("email2");
                String gender = request.getParameter("gender");
                double balance = 0.00;
                
                boolean usernameAvailable = false;
                
                try {
                            // This will load the MySQL driver, each DB has its own driver. You WILL NEED TO INSTALL THE DRIVER or you will get an error at runtime.
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            // Setup the connection with the DB
                            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/userDatabase"+ "?user=StephanieMetts&password=thePassword");
                            // Statements allow to issue SQL queries to the database
                            Statement statement = connect.createStatement();
                            // Result set get the result of the SQL query
                            ResultSet resultSet = statement.executeQuery("select * from userDatabase.userTable where username = '" + username + "';");
                            if(resultSet.next() == true)
                            {
                                usernameAvailable = false;
                            } else {
                                usernameAvailable = true;
                            }
                            
                            connect.close();
                            
                        }
                        catch(Exception e)
                        {
                            out.println("DATABASE PROBLEM");
                        }
            
            if(theUser == null) {
                
                if((firstname == null || firstname.equals("")) 
                        && (lastname == null || lastname.equals("")) 
                        && (username == null || username.equals("")) 
                        && (password == null || password.equals("")) 
                        && (email == null || email.equals("")) 
                        && (email2 == null || email2.equals("")) ) {

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>");
            out.println("<script src=\"userAvailability.js\"></script>");
                    out.println("<title>Registration Page</title>");
                    out.println("<meta charset=\"UTF-8\">");
                    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<ul>");
                        out.println("<li><a href=\"index\">Home Login/Logout</a></li>");
                        out.println("<li><a href=\"registration\">New User</a></li>");
                        out.println("<li><a href=\"content\">Products</a></li>");
                        out.println("<li><a href=\"cart\">Cart</a></li>");
                        out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                    out.println("</ul>");
                    out.println("<h1>Please Sign Up</h1>");
                    out.println("<form action=\"registration\" method= \"post\">");
                        out.println("First Name: <br><input type=\"text\" name=\"firstname\"><br>");
                        out.println("Last Name: <br><input type=\"text\" name=\"lastname\" ><br>");
                        out.println("User Name: <br><input type=\"text\" id =\"theUsername\" onmouseout='askServer()' name=\"username\" >");
                        out.print("<h4 id=\"usernameAvailable\">  Username Available</h4><br>");
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
            
                    //use javascript to display this message!!!!
                } else if (firstname.equals("") || firstname == null || lastname.equals("") || lastname == null || username.equals("") || username == null 
                    || password.equals("") || password == null || email.equals("") || email == null || email2.equals("") || email2 == null || !email.equals(email2) 
                    || gender.equals("") || gender == null || !email.contains("@") || !email.contains(".") || usernameAvailable == false) {
                    
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<body>");
                        out.println("<script>");
                            out.println("document.write(\"You are missing the following information:\");");
                        out.println("</script>");
                        out.println("</body>");
                        out.println("</html>");
                        
                        out.println("<br>");
                        if(firstname.equals("")) {
                            out.println("First Name<br>");
                        } 
                        if(lastname.equals("")) {
                            out.println("Last Name<br>");
                        }
                        if(username.equals("") || username == null) {
                            out.println("Username<br>");
                        }
                        if(password.equals("")) {
                            out.println("Password<br>");
                        }
                        if(email.equals("")) {
                            out.println("Email<br>");
                        }
                        if(!email.equals(email2)) {
                            out.println("Emails do not match<br>");
                        }
                        if(!email.contains("@") || !email.contains(".")) {
                            out.println("Email is not valid<br>");
                        }
                        if(usernameAvailable == false) {
                            out.println("The username " + username + " is not available.");
                            username = null;
                        }
                        
                        out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>");
            out.println("<script src=\"userAvailability.js\"></script>");
                    out.println("<title>Registration Page</title>");
                    out.println("<meta charset=\"UTF-8\">");
                    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<ul>");
                        out.println("<li><a href=\"index\">Home Login/Logout</a></li>");
                        out.println("<li><a href=\"registration\">New User</a></li>");
                        out.println("<li><a href=\"content\">Products</a></li>");
                        out.println("<li><a href=\"cart\">Cart</a></li>");
                        out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                    out.println("</ul>");
                    out.println("<h1>Please Sign Up</h1>");
                    out.println("<form action=\"registration\" method= \"post\">");
                        out.println("First Name: <br><input type=\"text\" name=\"firstname\" value = \" " + firstname + "\"><br>");
                        out.println("Last Name: <br><input type=\"text\" name=\"lastname\" value=\" " + lastname + "\" ><br>");
                        out.println("User Name: <br><input type=\"text\" id =\"theUsername\" onmouseout='askServer()' name=\"username\" >");
                        out.print("<h4 id=\"usernameAvailable\">  Username Available</h4><br>");
                        out.println("Email: <br><input type=\"text\" name=\"email\" value =\" " + email + " \"><br>");
                        out.println("Re-enter Email: <br><input type=\"text\" name=\"email2\" value=\" " + email2 + " \" ><br>");
                        out.println("Password:  <br><input type=\"password\" name=\"password\" value =\" " + password + " \" ><br>");
                        out.println("Gender: <br>");
                        out.println("<input type=\"radio\" name=\"gender\" value=\"male\" checked> Male");
                        out.println("<input type=\"radio\" name=\"gender\" value=\"female\"> Female");
                        out.println("<input type=\"radio\" name=\"gender\" value=\"noanswer\"> Prefer Not to Answer<br>");
                    out.println("<input type=\"submit\" value=\"Submit\" ><br>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                    } else {
                        //add code to create an account if everything is verified
                        //create a bean and place it on the session
                        
                        balance = 0.0;
                        
                        UserBean theUserBean = new UserBean();
                        theUserBean.setFirstName(firstname);
                        theUserBean.setLastName(lastname);
                        theUserBean.setUsername(username);
                        theUserBean.setEmail(email);
                        theUserBean.setPassword(password);
                        theUserBean.setBalance(balance);
                        theUserBean.setGender(gender);
                        
                        HttpSession userSession = request.getSession();
                        //userSession.setAttribute("session", UserSession);
                        UserSession.setAttribute("beanSession", theUserBean);

                        User aUser = new User();

                        aUser.firstName = firstname;
                        aUser.lastName = lastname;
                        aUser.username = username;
                        aUser.password = password;
                        aUser.email = email;
                        aUser.gender = gender;
                        aUser.balance = 0.00;

                        UserMap.theUserMap.put(username, aUser);
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
                            out.println("<li><a href=\"index\">Home Login/Logout</a></li>");
                            out.println("<li><a href=\"registration\">New User</a></li>");
                            out.println("<li><a href=\"content\">Products</a></li>");
                            out.println("<li><a href=\"cart\">Cart</a></li>");
                            out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                        out.println("</ul>");
                        out.println("</body>");
                        out.println("</html>");

                        UserSession.setAttribute("session", aUser);
                        out.println("Congratulations " + aUser.firstName +", you have registered.<br>");
                        
                                    out.println("<a href=\"otherViewRedirect\">Other View/User Information</a>");
                         try {
                            // This will load the MySQL driver, each DB has its own driver. You WILL NEED TO INSTALL THE DRIVER or you will get an error at runtime.
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            // Setup the connection with the DB
                            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/userdatabase"+ "?user=StephanieMetts&password=thePassword");
                            // Statements allow to issue SQL queries to the database
                            Statement statement = connect.createStatement();
                            // Result set get the result of the SQL query
                            //int numRowsChanged = statement.executeUpdate("insert into userdatabase.users (firstName, lastName, email, username. password, gender, balance) " + "VALUES (" +  "'" + firstname +  "'" + ", " + "'" + lastname + "'" + ", " + "'" + email + "'" + "," + "'" + password + "'" + "," + "'" + gender + "'" + ", " + "'" + balance + "'" + ");");
                            //out.println(numRowsChanged + " user has been created.");
                            statement.executeUpdate("insert into userdatabase.userTable (firstName, lastName, username, email, password, gender, balance) VALUES (" + "'" + firstname + "'" + "," + "'" + lastname + "'" + "," + "'" + username + "'" + "," + "'" + email + "'" + "," + "'" + password + "'" + "," + "'" + gender + "'" + "," + "'" + balance  + "'" + "); ");

                            connect.close();
                        }
                        catch(Exception e)
                        {
                            out.println("DATABASE PROBLEM");
                            e.printStackTrace();
                        }
                       // ServletContext theContext = this.getServletContext();
                        //theContext.getRequestDispatcher("./index/").forward(request, response);
                        //response.sendRedirect("./content/");
                    }
            } else {
                
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
                            out.println("<li><a href=\"index\">Home Login/Logout</a></li>");
                            out.println("<li><a href=\"registration\">New User</a></li>");
                            out.println("<li><a href=\"content\">Products</a></li>");
                            out.println("<li><a href=\"cart\">Cart</a></li>");
                            out.println("<li>");
                            out.println("<li><a href=\"orderhistory\">Order History</a></li>");
                        out.println("</ul>");
                        out.println("</body>");
                        out.println("</html>");
                    out.print("You have already registered.<br>");
                                    out.println("<a href=\"otherViewRedirect\">Other View/User Information</a>");
             } 
                   
            }  //end of print writer
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
