


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

public class Store extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext sc = getServletContext();
       PrintWriter out=response.getWriter();
        System.out.println("THis is store");
        try{
            String id=request.getParameter("id");
                    String pass=request.getParameter("pass");
                    String time=request.getParameter("time");
                    
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:resume","sa","Slietians");   
            Statement stat=con.createStatement();
            ResultSet rs=stat.executeQuery("select * from valid  where ID='"+id+"' and PASS='"+pass+"'");  
            if(rs.next()){
                System.out.println("REACHERD");
             stat.executeUpdate("insert into timer  values('"+id+"' ,'"+time+"')");
             System.out.println(id);
             ServletContext con1=request.getServletContext();
             con1.setAttribute("userid",id);
             
             // request.setAttribute("userid",id);
           //     RequestDispatcher rd=request.getRequestDispatcher("/CompanyUse?userid=aa");
           // rd.forward(request, response);
             response.sendRedirect("/CompanyUse?userid=aa");
           
            }
   
         }catch(Exception e){
        
        System.out.println("HELLOW "+e);
        }
    }
}
