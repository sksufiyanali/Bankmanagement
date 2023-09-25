import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn{
    Connection c;
    static Statement s;
    public conn(){  
        try{  
            //Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","systemsk@123");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
