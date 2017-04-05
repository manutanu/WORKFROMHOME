
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CompanyUse extends HttpServlet {
        
    Thread t=Thread.currentThread();

  
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    try {
         try{
             ServletContext con1=request.getServletContext();
           String id=(String)  con1.getAttribute("userid");
         //   String id=(String)request.getParameter("userid");
             //       String pass=request.getParameter("pass");
               //     String time=request.getParameter("time");
            System.out.println("READCHED HERE  "+ id+".............pinki");
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:resume","sa","Slietians");   
            Statement stat=con.createStatement();
            
            ResultSet rs=stat.executeQuery("select TIMESPEND from timer  where ID='"+id+"'");  
             System.out.println("READCHED HERE   hhhhhhhhhhhhh");
           
            while(rs.next()){
                 System.out.println("READCHED HERE pppppppppp  "+id);
           
            
            String t=rs.getString("TIMESPEND");
              System.out.println("READCHED HERE pppppppppp");
            long d=Long.parseLong(t);
            
            for(double d3=1;d3<1;){
                Date dt=new Date();
              long d2=dt.getTime();
               System.out.println(d2+" vvv  " + d+"  "+(d2-d));
            d3=d2-d;
            d3=d3/(60*1000);
           System.out.println(d3 +" minutes spent");
            Thread.sleep(30*1000);
            }
                 ServletOutputStream so=response.getOutputStream();
        
        BufferedOutputStream bis=new BufferedOutputStream(so);
          
         String name1="you are online for lessthan 1 minutes";
         System.err.println(name1);
          byte[] b=name1.getBytes();
          int counter=0;
         bis.write(b,0,b.length);
         bis.flush();
        
       
            }
            
         }catch(Exception e){
        
        System.out.println(e);
        }
        
        }catch(Exception e){
        System.out.println(e);
        }
       
    }

  
  

    
    
}
