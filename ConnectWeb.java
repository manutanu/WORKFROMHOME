

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL ;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class ConnectWeb {
 
  public static void main(String args[]) throws Exception {
 Date d=new Date();
     
      sendParameter(d);
try{
  // HttpClient client = new HttpClient();
  //  System.out.println("READRE");
    URL url = new URL("http://localhost:8084/Web/CompanyUse");
       URLConnection con= (URLConnection)url.openConnection();
      InputStream is = con.getInputStream();
     
      
      BufferedInputStream bis=new BufferedInputStream(is);
      

// PostMethod method = new PostMethod("http://localhost:8084/Web/CompanyUse?id="+str+"&pass="+yadav+"");
    
         //String str="1@gmail";
 byte[] b=new byte[1024*1024];
     //  client.executeMethod(method);
     
   int i;  
   //System.out.println("still cant get......");
   
   if(is.available()!=0){
       
       // System.out.println("got the STREAM");
  while((i=bis.read(b,0,b.length))!=-1){
         String mssg=new String(b);
         mssg=mssg.trim();
         DemoAction da=new DemoAction(mssg);
		da.setVisible(true);
		da.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		da.setBounds(900,620,500,150);
     }
      
    }else{
   System.out.println("NO INPUT STREAM COMINg");
   }
}catch(Exception e) {
      System.err.println(e);
    } finally {
     
    }
  }
  
 static public void sendParameter(Date d) throws MalformedURLException, ProtocolException, IOException{
   //  System.out.println("RUn");
long t=d.getTime();

    String time=Long.toString(t);
    //System.out.println(time);
Scanner sc=new Scanner(System.in);

 HttpClient httpClient = new HttpClient();
 System.out.println("ENETER YOUR ID");
 String id=sc.next();
 System.out.println("ENTER YOUR PASSWORD");
   String pass=sc.next();
 PostMethod postMethod = new PostMethod("http://localhost:8084/Web/Store?id="+id+"&pass="+pass+"&time="+time+"")
 {
    @Override
    public boolean getFollowRedirects()
    {
        return true;
    }
};
 System.out.println("RUn");
    try {
        httpClient.executeMethod(postMethod);
          System.out.println("RUn");
    } catch (Exception e) {
        System.out.println(e);
    }
 }
}