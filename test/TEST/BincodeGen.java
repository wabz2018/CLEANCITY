/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.util.Random;

/**
 *
 * @author Black-ish
 */
public class BincodeGen {
   static  String chars="abcdefghijklmnopqrstuvwxyz";
   static  String nums="0123456789";
  static String code="";
 static   Random rand= new Random();
    
//    public  static void main(String args[])
//    {
//
//       // System.out.println("Length " +chars.length()+ " size" +chars.substring(0, 4));
//      //  chars.toUpperCase();
//        
//      System.out.println("Random 1 :  " +getType(3)); 
//      System.out.println("Random 2: "+randomAlphaNumeric(6));
//        
//    }
  
    public static String getType( int count)
    {
        StringBuilder cod=new StringBuilder();
        StringBuilder cod1= new StringBuilder();
        while(count--!=0)
        {
        int ch=rand.nextInt(chars.length());
        cod.append(chars.charAt(ch));
        int ns=rand.nextInt(nums.length());
        cod1.append(nums.charAt(ns));
        code= cod.toString().toUpperCase() +""+cod1.toString();
        }
        
     // code= "P"+ chars.toUpperCase().charAt(rand.nextInt(chars.length())) + nums.charAt(rand.nextInt(nums.length()));
     
     return code;   
    }
   private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

public static String randomAlphaNumeric(int count) {

StringBuilder builder = new StringBuilder();

while (count-- != 0) {

int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

builder.append(ALPHA_NUMERIC_STRING.charAt(character));

}

return builder.toString();

}  
    
}
