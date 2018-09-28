/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancity;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Black-ish
 */
public class DBconnection {
    Connection mainlog;
    public Connection MainConn()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        //addresss on another machine
      // mainlog=DriverManager.getConnection("jdbc:mysql://192.168.1.122:3306/clean_city","charity","charity");//Robert
      // mainlog=DriverManager.getConnection("jdbc:mysql://192.168.1.193:3306/clean_city","charity","charity");//Chariy
        //localhost
       mainlog=DriverManager.getConnection("jdbc:mysql://localhost:3306/clean_city","root","");
        // mainlog=DriverManager.getConnection("jdbc:mysql://localhost:3306/knowledge","root","");
        System.out.print("Successfully connected");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Error");
        }
    return mainlog;
    
    }
}
