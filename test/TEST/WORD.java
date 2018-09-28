/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;
import cleancity.DBconnection;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Black-ish
 */
public class WORD {
    
    static Connection connect;
    static String sql ="";
    static PreparedStatement pst;
    static ResultSet rs;
    static String[] mycity= {"Bungoma","Nairobi","Kakamega","Busia","Kitui","Machakos","Nanyuki","Machakos"};
    static String[] mywards= {"Township","Milimani","Kangema", "North Hall", "Machakos", "Kajiado"};
    static String[] mycons={"Bumula","Mumias West","Khwisero","Kanduyi","Sirisia","Webuye East"};
    static String[] mysubject= new String[0];
 
    public  static void  main(String [] args)
    {
       
    System.out.println("There are: "+mycity.length + "  towns"); 
    for(int i=0; i<mycity.length; i++)
    {
    System.out.println(" " +mycity[i]);
    }
      System.out.println("There are: "+mywards.length + "  Wards"); 
    for(int i=0; i<mywards.length; i++)
    {
    System.out.println(" " +mywards[i]);
    }
    System.out.println("There are: "+mycons.length + "  Constituency"); 
    for(int i=0; i<mycons.length; i++)
    {
    System.out.println(" " +mycons[i]);
    }
   // MYworks();
    System.out.print("\n"+MYworks() +"\n");
    }
  public static String MYworks()
    {
  ArrayList<String> county = new ArrayList<String>();
ArrayList<String> capital = new ArrayList<String>();

// finally turn the array lists into arrays - if really needed
String[] countyName = new String[county.size()];
countyName = county.toArray(countyName);

String[] cap = new String[capital.size()];
cap = capital.toArray(cap);    
 TestDB  mycon= new TestDB();      
connect= mycon.MainConn();
sql="select * from subject";
try{pst=connect.prepareStatement(sql);
rs= pst.executeQuery();
while(rs.next())
{
    county.add(rs.getString(2));
    capital.add(rs.getString(3));
    
}

}
catch(Exception e)
{
    System.err.println("Error" +e.getMessage());
}
        return county +"\n" +capital; 
    }
}

